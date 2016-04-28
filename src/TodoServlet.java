import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MikhailKovalenko on 14.04.16.
 */
public class TodoServlet extends HttpServlet{

//    private ArrayList<String> tasks = new ArrayList<>();

    private  void  outputList(HttpServletResponse resp) throws IOException, ServletException {
        ArrayList<String> tasks = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
            try (PreparedStatement st = conn.prepareStatement("SELECT ID, TEXT FROM TODO ORDER BY ID DESC")) {
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String text = rs.getString(2);
                        tasks.add(text);
                    }
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        Map<String,Object> data = new HashMap<>();
        data.put("allTasks", tasks);
        TemplateUtil.render("todo.vsl", data, resp.getWriter());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        outputList(resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newTask=req.getParameter("newTask");
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
            try (PreparedStatement st = conn.prepareStatement ("INSERT INTO TODO (TEXT) VALUES (?)")){
                st.setString(1, newTask);
                st.execute();
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
  //      tasks.add(newTask);
        outputList(resp);
    }
}

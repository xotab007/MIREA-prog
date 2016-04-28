import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MikhailKovalenko on 14.04.16.
 */
public class TodoServlet extends HttpServlet{

    private ArrayList<String> tasks = new ArrayList<>();

    private  void  outputList(HttpServletResponse resp) throws IOException, ServletException {
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
        tasks.add(newTask);
        outputList(resp);
    }
}

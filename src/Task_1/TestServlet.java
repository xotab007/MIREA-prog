package Task_1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MikhailKovalenko on 14.04.16.
 */
public class TestServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("<html>\n" +
                "<head>\n" +
                "    <body>\n" +
                "    <form>\n" +
                "        Login: <input name=\"name\">\n" +
                "        <input type=\"submit\" value=\"OK\">\n" +
                "    </form>\n" +
                "    </body>\n" +
                "</head>\n" +
                "</html>");
    }
}

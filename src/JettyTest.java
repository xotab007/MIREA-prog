import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Created by MikhailKovalenko on 14.04.16.
 */
public class JettyTest {
    public static void main(String[] args) throws Exception {
        Server server = new Server (8080); //порт
        ServletContextHandler ctx = new ServletContextHandler(); // запуск сервера
        server.setHandler(ctx); // запуск сервера
        ctx.addServlet(TodoServlet.class, "/"); // перенаправление на класс
        server.start(); // запуск
    }
}

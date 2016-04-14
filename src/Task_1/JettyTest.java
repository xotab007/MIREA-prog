package Task_1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Created by MikhailKovalenko on 14.04.16.
 */
public class JettyTest {
    public static void main(String[] args) throws Exception {
        Server server = new Server (8080);
        ServletContextHandler ctx = new ServletContextHandler();
        server.setHandler(ctx);
        ctx.addServlet(TestServlet.class, "/");
        server.start();
    }
}

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.event.implement.EscapeHtmlReference;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import javax.servlet.ServletException;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;


public class TemplateUtil {

    static {
        Properties props = new Properties();
        try {
            props.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
            props.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
            props.setProperty(RuntimeConstants.EVENTHANDLER_REFERENCEINSERTION, EscapeHtmlReference.class.getName());
            Velocity.init(props);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void render(String template, Map<String, Object> data, Writer w)
            throws ServletException {
        try {
            Velocity.mergeTemplate(
                    template, "UTF-8", new VelocityContext(data), w
            );
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}

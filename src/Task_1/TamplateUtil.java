/* package Task_1;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.util.Properties;


public class TamplateUtil {

    static {
        Properties props = new Properties();
        try {
            props.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
            props.setProperty("class.resource.loaded.class", ClasspathResourceLoader.class.getName());
            Velocity.init(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
*/
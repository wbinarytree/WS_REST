import com.company.RestDataPush;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by BinaryTree on 2017/1/16.
 */
@ApplicationPath("/")
public class Test extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(RestDataPush.class);
        return h;
    }
}

import net.summerframework.mvc.controller.DefaultControllerActivator;
import net.summerframework.mvc.controller.DefaultControllerFactory;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        new DefaultControllerFactory(new DefaultControllerActivator());
    }
}

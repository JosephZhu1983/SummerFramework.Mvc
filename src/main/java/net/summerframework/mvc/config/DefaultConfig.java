package net.summerframework.mvc.config;

import net.summerframework.mvc.action.DefaultActionInvoker;
import net.summerframework.mvc.controller.DefaultControllerActivator;
import net.summerframework.mvc.controller.DefaultControllerFactory;
import net.summerframework.mvc.filter.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultConfig implements IConfig
{
    public void config(ConfigCenter configCenter)
    {
        configCenter.setControllerFactory(new DefaultControllerFactory(new DefaultControllerActivator()));
        configCenter.setActionInvoker(new DefaultActionInvoker());

        configCenter.removeAllRoutes();
        configCenter.addDefaultRoutePattern("default", "{controller??Home}/{action??Index}/{id?}");

        configCenter.removeAllFilterProviders();
        configCenter.addFilterProvider(new ControllerInstanceFilterProvider());
        configCenter.addFilterProvider(new AnnotationFilterProvider());
        configCenter.addFilterProvider(new GlobalFilters());
    }
}

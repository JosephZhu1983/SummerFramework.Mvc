package net.summerframework.mvc.config;

import net.summerframework.mvc.controller.DefaultControllerFactory;
import net.summerframework.mvc.controller.IControllerFactory;
import net.summerframework.mvc.routing.DefaultRoute;
import net.summerframework.mvc.routing.RouteTable;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ConfigCenter
{
    private static IControllerFactory controllerFactory;
    private static RouteTable routes = new RouteTable();

    public static IControllerFactory getControllerFactory()
    {
        return controllerFactory;
    }

    public static RouteTable getRoutes()
    {
        return routes;
    }

    public synchronized static void useDefaultConfig() throws Exception
    {
        controllerFactory = new DefaultControllerFactory();
        DefaultRoute defaultRoute = new DefaultRoute("{controller??Home}/{action??Index}/{id?}");
        routes.addRoute("default", defaultRoute);
    }
}

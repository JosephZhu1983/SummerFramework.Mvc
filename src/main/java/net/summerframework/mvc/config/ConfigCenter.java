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
    public static IControllerFactory getControllerFactory()
    {
        return controllerFactory;
    }

    private static IControllerFactory controllerFactory;

    public static RouteTable getRoutes()
    {
        return routes;
    }

    private static RouteTable routes = new RouteTable();

    public synchronized static void useDefaultConfig() throws Exception
    {
        controllerFactory = new DefaultControllerFactory();
        DefaultRoute defaultRoute = new DefaultRoute("{controller??Home}/{action??Index}/{id?}");
        routes.addRoute("default", defaultRoute);
    }
}

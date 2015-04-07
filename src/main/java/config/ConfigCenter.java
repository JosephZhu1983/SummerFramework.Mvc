package config;

import controller.DefaultControllerFactory;
import controller.IControllerFactory;
import routing.Route;
import routing.RouteDefault;

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

    public static Routes getRoutes()
    {
        return routes;
    }

    private static Routes routes;

    public synchronized void useDefaultConfig()
    {
        controllerFactory = new DefaultControllerFactory();
        routes = new Routes();
        Route defaultRoute = new Route("{controller}/{action}/{id}");
        defaultRoute.setDefault("controller", RouteDefault.setDefaultValue("Home"))
                .setDefault("action", RouteDefault.setDefaultValue("Index"))
                .setDefault("id", RouteDefault.allowOptional());
        routes.addRoute("default", defaultRoute);
    }
}

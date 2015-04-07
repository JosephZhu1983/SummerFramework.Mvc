package config;

import common.HttpRequestContext;
import routing.IRoute;
import routing.RouteData;

import java.util.concurrent.ConcurrentHashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class Routes
{
    private ConcurrentHashMap<String, IRoute> routes = new ConcurrentHashMap<String, IRoute>();

    public void addRoute(String routeName, IRoute route)
    {
        routes.put(routeName, route);
    }

    public RouteData getRouteData(HttpRequestContext httpRequestContext)
    {
        for (IRoute route : routes.values())
        {
            RouteData routeData = route.getRouteData(httpRequestContext);
            if (routeData != null)
            {
                return routeData;
            }
        }
        return null;
    }
}

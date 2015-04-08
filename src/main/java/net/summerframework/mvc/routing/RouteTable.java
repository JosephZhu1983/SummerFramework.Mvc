package net.summerframework.mvc.routing;

import net.summerframework.mvc.common.HttpContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class RouteTable
{
    private ConcurrentHashMap<String, IRoute> routes = new ConcurrentHashMap<String, IRoute>();

    public void addRoute(String routeName, IRoute route)
    {
        routes.put(routeName, route);
    }

    public RouteData getRouteData(HttpContext httpContext)
    {
        for (IRoute route : routes.values())
        {
            RouteData routeData = route.getRouteData(httpContext);
            if (routeData != null)
            {
                return routeData;
            }
        }
        return null;
    }
}

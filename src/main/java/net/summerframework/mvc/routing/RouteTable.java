package net.summerframework.mvc.routing;

import net.summerframework.mvc.common.HttpContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class RouteTable extends ConcurrentHashMap<String, IRoute>
{
    public RouteData getRouteData(HttpContext httpContext) throws RouteException
    {
        for (IRoute route : values())
        {
            RouteData routeData = route.getRouteData(httpContext);
            if (routeData != null)
            {
                return routeData;
            }
        }
        throw new RouteException(String.format("Can not find matched route for %s", httpContext.getRequest().getRequestURL()));
    }
}

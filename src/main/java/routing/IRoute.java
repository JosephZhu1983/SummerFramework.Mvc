package routing;

import common.HttpRequestContext;

import java.util.HashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IRoute
{
    RouteData getRouteData(HttpRequestContext httpContext);

    VirtualPathData getVirtualPathData(HttpRequestContext requestContext, HashMap<String, Object> values);
}

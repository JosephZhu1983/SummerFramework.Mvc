package net.summerframework.mvc.routing;

import net.summerframework.mvc.common.HttpContext;

import java.util.HashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IRoute
{
    RouteData getRouteData(HttpContext httpContext);

    VirtualPathData getVirtualPathData(HttpContext httpContext, HashMap<String, Object> values);
}

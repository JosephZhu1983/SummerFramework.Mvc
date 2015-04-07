package routing;

import common.HttpContext;
import common.RequestContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class RouteBase
{
    public abstract RouteData getRouteData(HttpContext httpContext);

    public abstract VirtualPathData getVirtualPathData(RequestContext requestContext, RouteValueDictionary values);
}

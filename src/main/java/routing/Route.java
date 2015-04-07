package routing;

import common.HttpRequestContext;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class Route implements IRoute
{
    private final String url;
    private final ConcurrentHashMap<String, RouteDefault> defaults;

    public Route(String url, ConcurrentHashMap<String, RouteDefault> defaults)
    {
        this.url = url;
        this.defaults = defaults;
    }

    public Route(String url)
    {
        this(url, new ConcurrentHashMap<String, RouteDefault>());
    }

    public Route setDefault(String placeHolder, RouteDefault routeDefault)
    {
        defaults.put(placeHolder, routeDefault);
        return this;
    }

    public RouteData getRouteData(HttpRequestContext httpRequestContext)
    {
        RouteData routeData = new RouteData(this);
        return routeData;
    }

    public VirtualPathData getVirtualPathData(HttpRequestContext requestContext, HashMap<String, Object> values)
    {
        return null;
    }
}

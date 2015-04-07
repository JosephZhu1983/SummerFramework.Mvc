package common;

import routing.RouteData;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class HttpContext
{
    private RouteData routeData;
    private final HttpRequestContext httpRequestContext;
    private final HttpResponseContext httpResponseContext;

    public HttpContext(HttpRequestContext httpRequestContext, HttpResponseContext httpResponseContext)
    {
        this.httpRequestContext = httpRequestContext;
        this.httpResponseContext = httpResponseContext;
    }

    public RouteData getRouteData()
    {
        return routeData;
    }

    public void setRouteData(RouteData routeData)
    {
        this.routeData = routeData;
    }
}

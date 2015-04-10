package net.summerframework.mvc.common;

import net.summerframework.mvc.controller.ControllerBase;
import net.summerframework.mvc.routing.RouteData;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerContext
{
    private HttpContext httpContext;
    private RouteData routeData;
    private ControllerBase controller;

    public ControllerContext()
    {

    }

    public ControllerContext(ControllerContext controllerContext)
    {
        this.httpContext = controllerContext.getHttpContext();
        this.routeData = controllerContext.getRouteData();
        this.controller = controllerContext.getController();
    }

    public ControllerBase getController()
    {
        return controller;
    }

    public void setController(ControllerBase controller)
    {
        this.controller = controller;
    }

    public RouteData getRouteData()
    {
        return routeData;
    }

    public void setRouteData(RouteData routeData)
    {
        this.routeData = routeData;
    }

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public void setHttpContext(HttpContext httpContext)
    {
        this.httpContext = httpContext;
    }
}

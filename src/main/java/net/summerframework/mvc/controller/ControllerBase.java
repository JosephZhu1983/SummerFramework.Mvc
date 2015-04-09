package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.ControllerContext;
import net.summerframework.mvc.common.HttpContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class ControllerBase implements IController
{
    protected ControllerContext controllerContext;

    protected abstract void executeCore();

    public void execute(HttpContext httpContext)
    {
        controllerContext = new ControllerContext();
        controllerContext.setController(this);
        controllerContext.setRouteData(httpContext.getRouteData());
        controllerContext.setHttpContext(httpContext);
        executeCore();
    }

    public void release()
    {

    }
}

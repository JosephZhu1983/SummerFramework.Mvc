package net.summerframework.mvc.controller;

import net.summerframework.mvc.action.ActionInvokerException;
import net.summerframework.mvc.common.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class ControllerBase implements IController
{
    protected ControllerContext controllerContext;

    protected abstract void executeCore() throws ControllerException;

    public void execute(HttpContext httpContext) throws ControllerException
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

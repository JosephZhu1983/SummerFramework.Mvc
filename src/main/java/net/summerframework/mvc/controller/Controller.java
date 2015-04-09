package net.summerframework.mvc.controller;

import net.summerframework.mvc.action.*;
import net.summerframework.mvc.common.ControllerException;
import net.summerframework.mvc.config.ConfigCenter;
import net.summerframework.mvc.filter.*;
import net.summerframework.mvc.view.PartialViewResult;
import net.summerframework.mvc.view.ViewResult;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class Controller extends ControllerBase implements IExceptionFilter, IActionFilter, IResultFilter
{
    private IActionInvoker actionInvoker = ConfigCenter.getInstance().getActionInvoker();

    public void onException(ExceptionContext filterContext)
    {

    }

    public void onActionExecuting(ActionExecutingContext filterContext)
    {

    }

    public void onActionExecuted(ActionExecutedContext filterContext)
    {

    }

    public void onResultExecuting(ResultExecutingContext filterContext)
    {

    }

    public void onResultExecuted(ResultExecutedContext filterContext)
    {

    }

    @Override
    protected void executeCore() throws ControllerException
    {
        String actionName = controllerContext.getRouteData().getActionName();
        try
        {
            actionInvoker.invokeAction(controllerContext, actionName);
        }
        catch (ActionInvokerException exception)
        {
            throw new ControllerException(String.format("Error executing controller : %s", this.toString()), exception);
        }
    }

    protected ViewResult view()
    {
        return new ViewResult();
    }

    protected PartialViewResult partialView()
    {
        return new PartialViewResult();
    }

    protected ContentResult content(String content)
    {
        return new ContentResult(content);
    }

    protected ContentResult content(String type, String charset, String content)
    {
        return new ContentResult(type, charset, content);
    }
}

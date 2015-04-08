package net.summerframework.mvc.controller;

import net.summerframework.mvc.action.ContentResult;
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
    protected void executeCore()
    {

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
        return new ContentResult();
    }
}

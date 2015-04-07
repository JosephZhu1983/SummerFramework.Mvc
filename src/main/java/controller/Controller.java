package controller;

import action.ContentResult;
import filter.*;
import view.PartialViewResult;
import view.ViewResult;

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

    protected ContentResult content()
    {
        return new ContentResult();
    }
}

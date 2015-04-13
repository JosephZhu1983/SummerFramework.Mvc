package net.summerframework.mvc.controller;

import net.summerframework.mvc.action.*;
import net.summerframework.mvc.common.ControllerException;
import net.summerframework.mvc.config.ConfigCenter;
import net.summerframework.mvc.filter.*;
import net.summerframework.mvc.view.PartialViewResult;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class Controller extends ControllerBase implements IGeneralFilter
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
        controllerContext.setController(this);
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
        return view(null, null, null);
    }

    protected ViewResult view(String viewName, String masterName, Object model)
    {
        ViewResult viewResult = new ViewResult();
        viewResult.setViewName(viewName);
        viewResult.setMasterName(masterName);
        viewResult.setViewData(getViewData());
        if (model != null)
        {
            viewResult.getViewData().setModel(model);
        }
        viewResult.setTempData(getTempData());
        return viewResult;
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

package net.summerframework.mvc.filter;

import net.summerframework.mvc.action.ActionResult;
import net.summerframework.mvc.common.ActionDescriptor;
import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ActionExecutedContext extends ControllerContext
{
    private ActionDescriptor actionDescriptor;
    private ActionResult actionResult;
    private boolean canceled;
    private Exception exception;
    private boolean exceptionHandled;

    public ActionExecutedContext(ControllerContext controllerContext, ActionDescriptor actionDescriptor, boolean canceled, Exception exception)
    {
        super(controllerContext);
        this.actionDescriptor = actionDescriptor;
        this.canceled = canceled;
        this.exception = exception;
    }

    public ActionDescriptor getActionDescriptor()
    {
        return actionDescriptor;
    }

    public void setActionDescriptor(ActionDescriptor actionDescriptor)
    {
        this.actionDescriptor = actionDescriptor;
    }

    public ActionResult getActionResult()
    {
        return actionResult;
    }

    public void setActionResult(ActionResult actionResult)
    {
        this.actionResult = actionResult;
    }

    public boolean isCanceled()
    {
        return canceled;
    }

    public void setCanceled(boolean canceled)
    {
        this.canceled = canceled;
    }

    public Exception getException()
    {
        return exception;
    }

    public void setException(Exception exception)
    {
        this.exception = exception;
    }

    public boolean isExceptionHandled()
    {
        return exceptionHandled;
    }

    public void setExceptionHandled(boolean exceptionHandled)
    {
        this.exceptionHandled = exceptionHandled;
    }
}

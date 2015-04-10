package net.summerframework.mvc.filter;

import net.summerframework.mvc.action.ActionResult;
import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ResultExecutedContext extends ControllerContext
{
    private ActionResult actionResult;
    private boolean canceled;
    private boolean exceptionHandled;
    private Exception exception;

    public ResultExecutedContext(ControllerContext controllerContext, ActionResult actionResult, boolean canceled, Exception exception)
    {
        super(controllerContext);
        this.actionResult = actionResult;
        this.exception = exception;
        this.canceled = canceled;
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

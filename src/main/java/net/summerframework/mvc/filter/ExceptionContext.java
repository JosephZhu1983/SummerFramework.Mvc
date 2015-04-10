package net.summerframework.mvc.filter;

import net.summerframework.mvc.action.ActionResult;
import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ExceptionContext extends ControllerContext
{
    private Exception exception;
    private boolean exceptionHandled;
    private ActionResult actionResult;

    public ExceptionContext(ControllerContext controllerContext, Exception exception)
    {
        super(controllerContext);
        this.exception = exception;
    }

    public ActionResult getActionResult()
    {
        return actionResult;
    }

    public void setActionResult(ActionResult actionResult)
    {
        this.actionResult = actionResult;
    }

    public boolean isExceptionHandled()
    {
        return exceptionHandled;
    }

    public void setExceptionHandled(boolean exceptionHandled)
    {
        this.exceptionHandled = exceptionHandled;
    }

    public Exception getException()
    {
        return exception;
    }

    public void setException(Exception exception)
    {
        this.exception = exception;
    }
}

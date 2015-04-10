package net.summerframework.mvc.filter;

import net.summerframework.mvc.action.ActionResult;
import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ResultExecutingContext extends ControllerContext
{
    private boolean cancel;
    private ActionResult actionResult;

    public ResultExecutingContext(ControllerContext controllerContext, ActionResult actionResult)
    {
        super(controllerContext);
        this.actionResult = actionResult;
    }

    public boolean isCancel()
    {
        return cancel;
    }

    public void setCancel(boolean cancel)
    {
        this.cancel = cancel;
    }

    public ActionResult getActionResult()
    {
        return actionResult;
    }

    public void setActionResult(ActionResult actionResult)
    {
        this.actionResult = actionResult;
    }
}

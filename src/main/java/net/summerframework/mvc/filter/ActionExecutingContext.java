package net.summerframework.mvc.filter;

import net.summerframework.mvc.action.ActionResult;
import net.summerframework.mvc.common.ActionDescriptor;
import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ActionExecutingContext extends ControllerContext
{
    private ActionDescriptor actionDescriptor;
    private ActionResult actionResult;

    public ActionExecutingContext(ControllerContext controllerContext, ActionDescriptor actionDescriptor)
    {
        super(controllerContext);
    }

    public ActionResult getActionResult()
    {
        return actionResult;
    }

    public void setActionResult(ActionResult actionResult)
    {
        this.actionResult = actionResult;
    }

    public ActionDescriptor getActionDescriptor()
    {
        return actionDescriptor;
    }

    public void setActionDescriptor(ActionDescriptor actionDescriptor)
    {
        this.actionDescriptor = actionDescriptor;
    }
}

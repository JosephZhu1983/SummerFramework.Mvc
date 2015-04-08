package net.summerframework.mvc.common;

import net.summerframework.mvc.action.ActionMethodSelector;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerDescriptor
{
    private final ActionMethodSelector actionMethodSelector = new ActionMethodSelector();

    public ActionDescriptor findAction(ControllerContext controllerContext, String actionName)
    {
        return null;
    }
}

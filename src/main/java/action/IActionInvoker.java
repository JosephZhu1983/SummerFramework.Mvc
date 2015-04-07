package action;

import common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IActionInvoker
{
    boolean invokeAction(ControllerContext controllerContext, String actionName);
}

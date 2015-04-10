package net.summerframework.mvc.action;

import net.summerframework.mvc.common.ControllerContext;

import java.lang.reflect.Method;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IActionMethodValidator
{
    boolean isValidForRequest(ControllerContext controllerContext, Method action, String[] condition);
}

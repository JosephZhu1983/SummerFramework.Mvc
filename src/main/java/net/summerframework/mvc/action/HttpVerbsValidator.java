package net.summerframework.mvc.action;

import net.summerframework.mvc.common.ControllerContext;

import java.lang.reflect.Method;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class HttpVerbsValidator implements IActionMethodValidator
{
    @Override
    public boolean isValidForRequest(ControllerContext controllerContext, Method action, String[] condition)
    {
        for (String httpMethod : condition)
        {
            if (httpMethod.equalsIgnoreCase(controllerContext.getHttpContext().getRequest().getMethod()))
            {
                return true;
            }
        }
        return false;
    }
}

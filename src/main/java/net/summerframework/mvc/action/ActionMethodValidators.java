package net.summerframework.mvc.action;

import net.summerframework.mvc.common.ControllerContext;

import java.lang.reflect.Method;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ActionMethodValidators
{
    public boolean isValidForRequest(ControllerContext controllerContext, Method action)
    {
        boolean valid = true;
        for (AcceptVerbs acceptVerbs : action.getAnnotationsByType(AcceptVerbs.class))
        {
            try
            {
                valid = acceptVerbs.validator().newInstance().isValidForRequest(controllerContext, action, acceptVerbs.condition());
            }
            catch (Exception exception)
            {
                valid = false;
            }
        }

        if (!valid)
        {
            return false;
        }

        for (AcceptGet acceptVerbs : action.getAnnotationsByType(AcceptGet.class))
        {
            try
            {
                valid = acceptVerbs.validator().newInstance().isValidForRequest(controllerContext, action, acceptVerbs.condition());
            }
            catch (Exception exception)
            {
                valid = false;
            }
        }

        return valid;
    }
}

package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.HttpContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultControllerActivator implements IControllerActivator
{
    public IController create(HttpContext httpContext, Class<? extends IController> controllerType) throws ControllerActivatorException
    {
        try
        {
            IController controller = controllerType.newInstance();
            return controller;
        }
        catch (Exception exception)
        {
            throw new ControllerActivatorException(String.format("Failed to create controller from type %s", controllerType.getName()), exception);
        }
    }
}

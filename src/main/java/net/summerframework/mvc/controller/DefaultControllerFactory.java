package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.HttpContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultControllerFactory implements IControllerFactory
{
    private IControllerActivator controllerActivator;

    public IController createController(HttpContext httpContext, String controllerName)
    {
        return null;
    }

    public void releaseController(IController controller)
    {

    }
}

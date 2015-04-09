package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.HttpContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IControllerFactory
{
    IController createController(HttpContext httpContext, String controllerName) throws ControllerActivatorException, ControllerFactoryException;

    void releaseController(IController controller);
}

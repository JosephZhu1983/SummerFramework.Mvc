package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.HttpContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IControllerActivator
{
    IController create(HttpContext httpContext, Class<? extends IController> controllerType) throws ControllerActivatorException;
}

package controller;

import common.HttpRequestContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IControllerActivator
{
    IController create(HttpRequestContext requestContext, Class<IController> controllerType);
}

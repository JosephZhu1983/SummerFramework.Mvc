package controller;

import common.RequestContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IControllerActivator
{
    IController create(RequestContext requestContext, Class<IController> controllerType);
}

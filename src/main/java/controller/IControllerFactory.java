package controller;

import common.RequestContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IControllerFactory
{
    IController createController(RequestContext requestContext, String controllerName);

    void releaseController(IController controller);
}

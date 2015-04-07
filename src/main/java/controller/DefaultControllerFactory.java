package controller;

import common.RequestContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultControllerFactory implements IControllerFactory
{
    private IControllerActivator controllerActivator;

    public IController createController(RequestContext requestContext, String controllerName)
    {
        return null;
    }

    public void releaseController(IController controller)
    {

    }
}

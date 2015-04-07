package controller;

import common.RequestContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class ControllerBase implements IController
{
    protected abstract void executeCore();

    public void execute(RequestContext requestContext)
    {

    }
}

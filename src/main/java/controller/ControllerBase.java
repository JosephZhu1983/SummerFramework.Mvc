package controller;

import common.HttpRequestContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class ControllerBase implements IController
{
    protected abstract void executeCore();

    public void execute(HttpRequestContext requestContext)
    {

    }
}

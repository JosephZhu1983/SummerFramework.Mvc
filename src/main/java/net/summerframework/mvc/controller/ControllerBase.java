package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.HttpContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class ControllerBase implements IController
{
    protected abstract void executeCore();

    public void execute(HttpContext httpContext)
    {

    }
}

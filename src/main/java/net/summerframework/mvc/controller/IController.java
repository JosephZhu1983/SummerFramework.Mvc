package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.ControllerException;
import net.summerframework.mvc.common.HttpContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IController
{
    void execute(HttpContext requestContext) throws ControllerException;

    void release();
}

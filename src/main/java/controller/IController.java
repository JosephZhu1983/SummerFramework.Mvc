package controller;

import common.HttpContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IController
{
    void execute(HttpContext requestContext);
}

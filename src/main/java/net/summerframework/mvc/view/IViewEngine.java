package net.summerframework.mvc.view;

import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IViewEngine
{
    ViewEngineResult findPartialView(ControllerContext controllerContext, String partialViewName);

    ViewEngineResult findView(ControllerContext controllerContext, String viewName, String masterName);

    void releaseView(ControllerContext controllerContext, IView view);
}

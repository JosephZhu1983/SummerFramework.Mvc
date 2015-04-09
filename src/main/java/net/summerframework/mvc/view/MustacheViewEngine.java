package net.summerframework.mvc.view;

import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class MustacheViewEngine implements IViewEngine
{
    @Override
    public ViewEngineResult findPartialView(ControllerContext controllerContext, String partialViewName)
    {
        return null;
    }

    @Override
    public ViewEngineResult findView(ControllerContext controllerContext, String viewName, String masterName)
    {
        return null;
    }

    @Override
    public void ReleaseView(ControllerContext controllerContext, IView view)
    {

    }
}

package net.summerframework.mvc.view;

import net.summerframework.mvc.common.ControllerContext;

import java.util.ArrayList;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ViewEngines extends ArrayList<IViewEngine>
{
    public ViewEngineResult findPartialView(ControllerContext controllerContext, String partialViewName)
    {
        return null;
    }

    ViewEngineResult findView(ControllerContext controllerContext, String viewName, String masterName)
    {
        return null;
    }

}

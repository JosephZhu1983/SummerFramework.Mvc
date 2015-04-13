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

    public ViewEngineResult findView(ControllerContext controllerContext, String viewName, String masterName)
    {
        ArrayList<String> searchedLocations = new ArrayList<>();
        for (IViewEngine viewEngine : this)
        {
            ViewEngineResult viewEngineResult = viewEngine.findView(controllerContext, viewName, masterName);
            if (viewEngineResult.getView() != null)
            {
                return viewEngineResult;
            }
            else
            {
                searchedLocations.addAll(viewEngineResult.getSearchedLocations());
            }
        }
        return new ViewEngineResult(searchedLocations);
    }

}

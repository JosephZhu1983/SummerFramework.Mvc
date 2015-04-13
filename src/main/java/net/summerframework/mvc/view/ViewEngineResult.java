package net.summerframework.mvc.view;

import java.util.List;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ViewEngineResult
{
    private List<String> searchedLocations;
    private IView view;
    private IViewEngine viewEngine;

    public ViewEngineResult(List<String> searchedLocations)
    {
        this.searchedLocations = searchedLocations;
    }

    public ViewEngineResult(IView view, IViewEngine viewEngine)
    {
        this.view = view;
        this.viewEngine = viewEngine;
    }

    public List<String> getSearchedLocations()
    {
        return searchedLocations;
    }

    public IView getView()
    {
        return view;
    }

    public IViewEngine getViewEngine()
    {
        return viewEngine;
    }
}

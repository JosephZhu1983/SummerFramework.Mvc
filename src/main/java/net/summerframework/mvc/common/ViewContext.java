package net.summerframework.mvc.common;

import net.summerframework.mvc.view.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ViewContext extends ControllerContext
{
    private ViewData viewData;
    private TempData tempData;
    private IView view;

    public ViewData getViewData()
    {
        return viewData;
    }

    public void setViewData(ViewData viewData)
    {
        this.viewData = viewData;
    }

    public TempData getTempData()
    {
        return tempData;
    }

    public void setTempData(TempData tempData)
    {
        this.tempData = tempData;
    }

    public IView getView()
    {
        return view;
    }

    public void setView(IView view)
    {
        this.view = view;
    }
}

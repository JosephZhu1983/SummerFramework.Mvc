package net.summerframework.mvc.view;

import net.summerframework.mvc.action.ActionResult;
import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ViewResult extends ActionResult
{
    private IView view;
    private String viewName;
    private String masterName;
    private ViewData viewData;
    private TempData tempData;

    public String getMasterName()
    {
        return masterName;
    }

    public void setMasterName(String masterName)
    {
        this.masterName = masterName;
    }

    public IView getView()
    {
        return view;
    }

    public void setView(IView view)
    {
        this.view = view;
    }

    public String getViewName()
    {
        return viewName;
    }

    public void setViewName(String viewName)
    {
        this.viewName = viewName;
    }

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

    @Override
    public void executeResult(ControllerContext controllerContext)
    {

    }
}

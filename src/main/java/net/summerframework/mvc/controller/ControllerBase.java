package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.*;
import net.summerframework.mvc.view.TempData;
import net.summerframework.mvc.view.ViewData;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class ControllerBase implements IController
{
    protected ControllerContext controllerContext;
    private TempData tempData;
    private ViewData viewData;

    public TempData getTempData()
    {
        if (tempData == null)
        {
            tempData = new TempData();
        }
        return tempData;
    }

    public void setTempData(TempData tempData)
    {
        this.tempData = tempData;
    }

    public ViewData getViewData()
    {
        if (viewData == null)
        {
            viewData = new ViewData();
        }
        return viewData;
    }

    public void setViewData(ViewData viewData)
    {
        this.viewData = viewData;
    }

    protected abstract void executeCore() throws ControllerException;

    public void execute(HttpContext httpContext) throws ControllerException
    {
        controllerContext = new ControllerContext();
        controllerContext.setRouteData(httpContext.getRouteData());
        controllerContext.setHttpContext(httpContext);
        executeCore();
    }

    public void release()
    {

    }
}

package net.summerframework.mvc.action;

import net.summerframework.mvc.common.ControllerContext;
import net.summerframework.mvc.common.ViewContext;
import net.summerframework.mvc.config.ConfigCenter;
import net.summerframework.mvc.view.*;

import java.io.IOException;
import java.io.PrintWriter;

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
    public void executeResult(ControllerContext controllerContext) throws ActionResultException
    {
        if (viewName == null)
        {
            viewName = controllerContext.getRouteData().getActionName();
        }

        ViewEngineResult viewEngineResult = null;

        if (view == null)
        {
            viewEngineResult = ConfigCenter.getInstance().getViewEngines().findView(controllerContext, viewName, masterName);
            if (viewEngineResult.getView() == null)
            {
                String searchedLocations = viewEngineResult.getSearchedLocations().stream().reduce((a, b) -> a + System.getProperty("line.separator") + b).get();
                throw new ActionResultException(String.format("Can not find view after searching below locations : %s", searchedLocations));
            }
            view = viewEngineResult.getView();
        }

        PrintWriter writer = null;
        try
        {
            writer = controllerContext.getHttpContext().getResponse().getWriter();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

        ViewContext viewContext = new ViewContext(controllerContext, view, viewData, tempData, writer);
        try
        {
            view.render(viewContext);
        }
        catch (ViewException exception)
        {
            throw new ActionResultException("Error rendering view", exception);
        }

        if (viewEngineResult != null)
        {
            viewEngineResult.getViewEngine().releaseView(controllerContext, view);
        }
    }
}

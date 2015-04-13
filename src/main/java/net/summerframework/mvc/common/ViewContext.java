package net.summerframework.mvc.common;

import net.summerframework.mvc.view.*;

import java.io.PrintWriter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ViewContext extends ControllerContext
{
    private final ViewData viewData;
    private final TempData tempData;
    private final IView view;
    private final PrintWriter writer;

    public ViewContext(ControllerContext controllerContext, IView view, ViewData viewData, TempData tempData, PrintWriter writer)
    {
        super(controllerContext);
        this.view = view;
        this.viewData = viewData;
        this.tempData = tempData;
        this.writer = writer;
    }

    public PrintWriter getWriter()
    {
        return writer;
    }

    public ViewData getViewData()
    {
        return viewData;
    }

    public TempData getTempData()
    {
        return tempData;
    }

    public IView getView()
    {
        return view;
    }

}

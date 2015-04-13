package net.summerframework.mvc.startup;

import net.summerframework.mvc.common.ControllerException;
import net.summerframework.mvc.common.HttpContext;
import net.summerframework.mvc.config.ConfigCenter;
import net.summerframework.mvc.config.DefaultConfig;
import net.summerframework.mvc.controller.*;
import net.summerframework.mvc.routing.RouteData;
import net.summerframework.mvc.routing.RouteException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DispatcherServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        super.init();
        new DefaultConfig().config(ConfigCenter.getInstance());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpContext httpContext = new HttpContext(request, response);
        RouteData routeData;
        try
        {
            routeData = ConfigCenter.getInstance().getRouteTable().getRouteData(httpContext);
        }
        catch (RouteException exception)
        {
            throw new ServletException(exception.getMessage(), exception);
        }

        String controllerName = routeData.getControllerName();

        IControllerFactory controllerFactory = ConfigCenter.getInstance().getControllerFactory();
        IController controller;
        try
        {
            controller = controllerFactory.createController(httpContext, controllerName);
        }
        catch (ControllerActivatorException | ControllerFactoryException exception)
        {
            throw new ServletException(exception.getMessage(), exception);
        }
        if (controller != null)
        {
            try
            {
                controller.execute(httpContext);
            }
            catch (ControllerException exception)
            {
                throw new ServletException(exception.getMessage(), exception);
            }
            controllerFactory.releaseController(controller);
        }
    }
}
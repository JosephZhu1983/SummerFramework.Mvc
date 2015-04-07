package startup;

import common.*;
import config.ConfigCenter;
import controller.IController;
import controller.IControllerFactory;
import routing.RouteData;

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
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpRequestContext httpRequestContext = new HttpRequestContext(request);
        HttpResponseContext httpResponseContext = new HttpResponseContext(response);
        HttpContext httpContext = new HttpContext(httpRequestContext, httpResponseContext);
        RouteData routeData = ConfigCenter.getRoutes().getRouteData(httpRequestContext);
        if (routeData == null)
            throw new ServletException("Can not find matched route for this url!");
        String controllerName = routeData.getControllerName();
        IControllerFactory controllerFactory = ConfigCenter.getControllerFactory();
        IController controller = controllerFactory.createController(httpContext, controllerName);
        controller.execute(httpContext);
        controllerFactory.releaseController(controller);
    }
}

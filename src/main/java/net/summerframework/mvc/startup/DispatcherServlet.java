package net.summerframework.mvc.startup;

import net.summerframework.mvc.common.HttpContext;
import net.summerframework.mvc.config.ConfigCenter;
import net.summerframework.mvc.controller.IController;
import net.summerframework.mvc.controller.IControllerFactory;
import net.summerframework.mvc.routing.RouteData;

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
        HttpContext httpContext = new HttpContext(request, response);
        RouteData routeData = ConfigCenter.getInstance().getRouteTable().getRouteData(httpContext);
        if (routeData == null)
            throw new ServletException(String.format("Can not find matched route for %s", request.getRequestURL()));
        String controllerName = routeData.getControllerName();

        IControllerFactory controllerFactory = ConfigCenter.getInstance().getControllerFactory();
        IController controller = controllerFactory.createController(httpContext, controllerName);
        controller.execute(httpContext);
        controllerFactory.releaseController(controller);


        //System.out.println(request.getServletContext().getRealPath("template.mustache"));
        //MustacheFactory mf = new DefaultMustacheFactory("views");
        // Mustache mustache = mf.compile("template.mustache");
        // mustache.execute(response.getWriter(), new Example()).flush();




       /* VelocityEngine ve = new VelocityEngine();
        //ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "path/to/templates");

        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        *//*  next, get the Template  *//*
        Template t = ve.getTemplate("helloworld.vm");

        *//*  create a context and add data *//*
         *//* create our list of maps  *//*
        ArrayList list = new ArrayList();
        Map map = new HashMap();
        map.put("name", "horse");
        map.put("price", "00.00");
        list.add(map);

        map = new HashMap();
        map.put("name", "dog");
        map.put("price", "9.99");
        list.add(map);
        map = new HashMap();
        map.put("name", "bear");
        map.put("price", ".99");
        list.add(map);

        VelocityContext context = new VelocityContext();
        context.put("petList", list);

        *//* now render the template into a StringWriter *//*
        StringWriter writer = new StringWriter();
        t.merge(context, response.getWriter());
        */
    }
}
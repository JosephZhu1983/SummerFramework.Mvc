package net.summerframework.mvc.startup;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

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
        System.out.println("DispatcherServlet.init");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("DispatcherServlet.service");
        //HttpContext httpContext = new HttpContext(request, response);
        //RouteData routeData = ConfigCenter.getRoutes().getRouteData(httpContext);
        //if (routeData == null)
        //    throw new ServletException("Can not find matched route for this url!");
        //String controllerName = routeData.getControllerName();

        System.out.println(request.getServletContext().getRealPath("template.mustache"));
        //MustacheFactory mf = new DefaultMustacheFactory("views");
        // Mustache mustache = mf.compile("template.mustache");
        // mustache.execute(response.getWriter(), new Example()).flush();

        /*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        //ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "path/to/templates");

        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate("helloworld.vm");

        /*  create a context and add data */
         /* create our list of maps  */
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
   /*  add that list to a VelocityContext  */
        VelocityContext context = new VelocityContext();
        context.put("petList", list);

        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, response.getWriter());


        //IControllerFactory controllerFactory = ConfigCenter.getControllerFactory();
        //IController controller = controllerFactory.createController(httpContext, controllerName);
        //controller.execute(httpContext);
        //controllerFactory.releaseController(controller);
    }
}

class Example
{

    List<Item> items()
    {
        return Arrays.asList(
                new Item("Item 1", "$19.99", Arrays.asList(new Feature("New!"), new Feature("Awesome!"))),
                new Item("Item 2", "$29.99", Arrays.asList(new Feature("Old."), new Feature("Ugly.")))
        );
    }

    static class Item
    {
        Item(String name, String price, List<Feature> features)
        {
            this.name = name;
            this.price = price;
            this.features = features;
        }

        String name, price;
        List<Feature> features;
    }

    static class Feature
    {
        Feature(String description)
        {
            this.description = description;
        }

        String description;
    }
}

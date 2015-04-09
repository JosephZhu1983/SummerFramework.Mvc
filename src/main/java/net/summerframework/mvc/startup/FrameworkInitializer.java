package net.summerframework.mvc.startup;

import net.summerframework.mvc.config.ConfigCenter;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
@WebListener
public class FrameworkInitializer implements ServletContextListener
{

    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        ServletContext servletContext = servletContextEvent.getServletContext();
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("summerframework.mvc", DispatcherServlet.class);
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/*");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {

    }
}

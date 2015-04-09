package net.summerframework.mvc.config;

import net.summerframework.mvc.controller.DefaultControllerFactory;
import net.summerframework.mvc.controller.IControllerFactory;
import net.summerframework.mvc.routing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ConfigCenter
{
    private static final ConfigCenter instance = new ConfigCenter();

    public static ConfigCenter getInstance()
    {
        return instance;
    }

    private ConfigCenter()
    {
    }

    private final Logger logger = LoggerFactory.getLogger(ConfigCenter.class);

    private IControllerFactory controllerFactory;
    private final RouteTable routeTable = new RouteTable();

    public IControllerFactory getControllerFactory()
    {
        return controllerFactory;
    }

    protected void setControllerFactory(IControllerFactory controllerFactory)
    {
        this.controllerFactory = controllerFactory;
    }

    public RouteTable getRouteTable()
    {
        return routeTable;
    }

    protected void addRoute(String routeName, IRoute route)
    {
        routeTable.put(routeName, route);
    }

    protected void addDefaultRoutePattern(String routeName, String pattern)
    {
        try
        {
            addRoute(routeName, new DefaultRoute(pattern));
        }
        catch (Exception e)
        {
            logger.warn(e.getMessage());
        }
    }

    protected void removeAllRoutes()
    {
        routeTable.clear();
    }

}

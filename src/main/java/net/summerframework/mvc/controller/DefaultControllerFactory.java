package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.HttpContext;
import net.summerframework.mvc.config.DefaultConfig;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultControllerFactory implements IControllerFactory
{
    private IControllerActivator controllerActivator;
    private static Map<String, Class<? extends IController>> controllerTypes = new HashMap<>();

    static
    {
        Reflections reflections = new Reflections();
        for(Class<? extends IController> controllerType : reflections.getSubTypesOf(IController.class))
        {
            if (controllerType != ControllerBase.class && controllerType != Controller.class)
            {
                controllerTypes.put(controllerType.getName(), controllerType);
            }
        }
    }
    public DefaultControllerFactory(IControllerActivator controllerActivator)
    {
        this.controllerActivator = controllerActivator;
    }

    public IController createController(HttpContext httpContext, String controllerName)
    {
        return null;
    }

    public void releaseController(IController controller)
    {

    }
}

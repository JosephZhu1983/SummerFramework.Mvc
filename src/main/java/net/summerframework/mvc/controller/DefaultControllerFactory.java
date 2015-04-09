package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.HttpContext;
import net.summerframework.mvc.config.DefaultConfig;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import javax.servlet.ServletException;
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
    private static Set<Class<? extends IController>> controllerTypes;

    static
    {
        Reflections reflections = new Reflections();
        for(Class<? extends IController> controllerType : reflections.getSubTypesOf(IController.class))
        {
            if (controllerType != ControllerBase.class && controllerType != Controller.class)
            {
                controllerTypes.add(controllerType);
            }
        }
    }
    public DefaultControllerFactory(IControllerActivator controllerActivator)
    {
        this.controllerActivator = controllerActivator;
    }

    public IController createController(HttpContext httpContext, String controllerName) throws ControllerActivatorException, ControllerFactoryException
    {
        for(Class<? extends IController> controllerType : controllerTypes)
        {
            if (controllerType.getSimpleName().equalsIgnoreCase(controllerName))
            {
                return controllerActivator.create(httpContext, controllerType);
            }
        }
        throw new ControllerFactoryException(String.format("Can not find matched controller to name %s", controllerName));
    }

    public void releaseController(IController controller)
    {
        controller.release();
    }
}

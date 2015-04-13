package net.summerframework.mvc.controller;

import net.summerframework.mvc.common.HttpContext;
import org.reflections.Reflections;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultControllerFactory implements IControllerFactory
{
    private static Set<Class<? extends IController>> controllerTypes;

    static
    {
        Reflections reflections = new Reflections("controllers");
        for (Class<? extends IController> controllerType : reflections.getSubTypesOf(IController.class))
        {
            if (controllerType != ControllerBase.class && controllerType != Controller.class)
            {
                controllerTypes.add(controllerType);
            }
        }
    }

    private IControllerActivator controllerActivator;

    public DefaultControllerFactory(IControllerActivator controllerActivator)
    {
        this.controllerActivator = controllerActivator;
    }

    public IController createController(HttpContext httpContext, String controllerName) throws ControllerActivatorException, ControllerFactoryException
    {
        List<Class<? extends IController>> matchedControllerTypes = controllerTypes.stream().filter(controllerType -> controllerType.getSimpleName().equalsIgnoreCase(controllerName)).collect(Collectors.toList());
        if (matchedControllerTypes.size() == 0)
        {
            throw new ControllerFactoryException(String.format("Can not find controller matched to name %s", controllerName));
        }
        else if (matchedControllerTypes.size() == 1)
        {
            return controllerActivator.create(httpContext, matchedControllerTypes.get(0));
        }
        else
        {
            throw new ControllerFactoryException(String.format("Too many controllers matched to name %s, result : %s", controllerName, controllerTypes.stream()
                    .map(type -> type.getName()).reduce((a, b) -> a + "," + b).get()));
        }
    }

    public void releaseController(IController controller)
    {
        controller.release();
    }
}

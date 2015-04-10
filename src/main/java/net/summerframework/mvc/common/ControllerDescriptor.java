package net.summerframework.mvc.common;

import net.summerframework.mvc.action.ActionMethodSelector;
import net.summerframework.mvc.action.ActionResult;
import net.summerframework.mvc.controller.IController;
import net.summerframework.mvc.filter.*;

import java.lang.reflect.Method;
import java.util.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerDescriptor
{
    private final Class<? extends IController> controllerType;
    private final String controllerName;
    private final ActionMethodSelector actionMethodSelector = new ActionMethodSelector();
    private final List<ActionDescriptor> actionDescriptors = new ArrayList<>();
    private List<FilterInfo> filtersInfo = new ArrayList<>();
    public ControllerDescriptor(Class<? extends IController> controllerType)
    {
        this.controllerType = controllerType;
        this.controllerName = controllerType.getName();
        for (Method method : controllerType.getMethods())
        {
            if (method.getReturnType() == ActionResult.class)
            {
                actionDescriptors.add(new ActionDescriptor(method, this));
            }
        }
        init();
    }

    public String getControllerName()
    {
        return controllerName;
    }

    public Collection<FilterInfo> getFiltersInfo()
    {
        return filtersInfo;
    }

    public ActionDescriptor findAction(ControllerContext controllerContext, String actionName)
    {
        Method action = actionMethodSelector.findActionMethod(controllerContext, actionName);
        return new ActionDescriptor(action, this);
    }

    private void init()
    {
        for (GeneralFilter filter : controllerType.getAnnotationsByType(GeneralFilter.class))
        {
            filtersInfo.add(new FilterInfo(filter.type(), FilterScope.Controller, filter.order()));
        }
        for (ExceptionFilter filter : controllerType.getAnnotationsByType(ExceptionFilter.class))
        {
            filtersInfo.add(new FilterInfo(filter.type(), FilterScope.Controller, filter.order()));
        }
        for (ActionFilter filter : controllerType.getAnnotationsByType(ActionFilter.class))
        {
            filtersInfo.add(new FilterInfo(filter.type(), FilterScope.Controller, filter.order()));
        }
        for (ResultFilter filter : controllerType.getAnnotationsByType(ResultFilter.class))
        {
            filtersInfo.add(new FilterInfo(filter.type(), FilterScope.Controller, filter.order()));
        }
    }
}

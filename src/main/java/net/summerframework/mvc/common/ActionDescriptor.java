package net.summerframework.mvc.common;

import net.summerframework.mvc.filter.*;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ActionDescriptor
{
    private final Method action;
    private final ControllerDescriptor controllerDescriptor;
    private final List<ParameterDescriptor> parameterDescriptors = new ArrayList<>();
    private String actionName;
    private List<FilterInfo> filtersInfo = new ArrayList<>();
    public ActionDescriptor(Method action, ControllerDescriptor controllerDescriptor)
    {
        this.action = action;
        this.controllerDescriptor = controllerDescriptor;
        for (Parameter parameter : action.getParameters())
        {
            parameterDescriptors.add(new ParameterDescriptor(parameter, this));
        }
        init();
    }

    public String getActionName()
    {
        return actionName;
    }

    public ControllerDescriptor getControllerDescriptor()
    {
        return controllerDescriptor;
    }

    private void init()
    {
        actionName = action.getName();
        for (GeneralFilter filter : action.getAnnotationsByType(GeneralFilter.class))
        {
            filtersInfo.add(new FilterInfo(filter.type(), FilterScope.Action, filter.order()));
        }
        for (ExceptionFilter filter : action.getAnnotationsByType(ExceptionFilter.class))
        {
            filtersInfo.add(new FilterInfo(filter.type(), FilterScope.Action, filter.order()));
        }
        for (ActionFilter filter : action.getAnnotationsByType(ActionFilter.class))
        {
            filtersInfo.add(new FilterInfo(filter.type(), FilterScope.Action, filter.order()));
        }
        for (ResultFilter filter : action.getAnnotationsByType(ResultFilter.class))
        {
            filtersInfo.add(new FilterInfo(filter.type(), FilterScope.Action, filter.order()));
        }
    }

    public Collection<FilterInfo> getFiltersInfo()
    {
        return filtersInfo;
    }
}

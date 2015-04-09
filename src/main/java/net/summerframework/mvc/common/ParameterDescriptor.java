package net.summerframework.mvc.common;

import java.lang.reflect.Parameter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ParameterDescriptor
{
    private final Parameter parameter;
    private final ActionDescriptor actionDescriptor;
    private String parameterName;

    public ParameterDescriptor(Parameter parameter, ActionDescriptor actionDescriptor)
    {
        this.parameter = parameter;
        this.actionDescriptor = actionDescriptor;
        init();
    }

    private void init()
    {
        this.parameterName = parameter.getName();
    }
}

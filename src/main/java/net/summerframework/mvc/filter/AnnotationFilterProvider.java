package net.summerframework.mvc.filter;

import net.summerframework.mvc.common.ActionDescriptor;
import net.summerframework.mvc.common.ControllerContext;

import java.util.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class AnnotationFilterProvider implements IFilterProvider
{
    public Collection<FilterInfo> getFiltersInfo(ControllerContext controllerContext, ActionDescriptor actionDescriptor)
    {
        List<FilterInfo> filters = new ArrayList<>();
        filters.addAll(actionDescriptor.getControllerDescriptor().getFiltersInfo());
        filters.addAll(actionDescriptor.getFiltersInfo());
        return filters;
    }
}

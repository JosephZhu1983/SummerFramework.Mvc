package net.summerframework.mvc.filter;

import net.summerframework.mvc.common.ActionDescriptor;
import net.summerframework.mvc.common.ControllerContext;

import java.util.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerInstanceFilterProvider implements IFilterProvider
{
    public Collection<FilterInfo> getFiltersInfo(ControllerContext controllerContext, ActionDescriptor actionDescriptor)
    {
        List<FilterInfo> filters = new ArrayList<>();
        FilterInfo filterInfo = new FilterInfo(controllerContext.getController().getClass(), FilterScope.First, Integer.MIN_VALUE);
        filters.add(filterInfo);
        return filters;
    }
}

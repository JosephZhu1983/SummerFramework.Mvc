package net.summerframework.mvc.filter;

import net.summerframework.mvc.common.ActionDescriptor;
import net.summerframework.mvc.common.ControllerContext;

import java.util.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class FilterProviders extends ArrayList<IFilterProvider> implements IFilterProvider
{
    @Override
    public Collection<FilterInfo> getFiltersInfo(ControllerContext controllerContext, ActionDescriptor actionDescriptor)
    {
        List<FilterInfo> filters = new ArrayList<>();

        for (IFilterProvider filterProvider : this)
        {
            filters.addAll(filterProvider.getFiltersInfo(controllerContext, actionDescriptor));
        }

        return filters;
    }
}

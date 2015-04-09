package net.summerframework.mvc.filter;

import net.summerframework.mvc.common.ActionDescriptor;
import net.summerframework.mvc.common.ControllerContext;

import java.util.ArrayList;
import java.util.Collection;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class GlobalFilters extends ArrayList<IFilter> implements IFilterProvider
{
    @Override
    public Collection<FilterInfo> getFiltersInfo(ControllerContext controllerContext, ActionDescriptor actionDescriptor)
    {
        return null;
    }
}

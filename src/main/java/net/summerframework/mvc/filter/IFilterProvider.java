package net.summerframework.mvc.filter;

import net.summerframework.mvc.common.ActionDescriptor;
import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IFilterProvider
{
    Iterable<Filter> getFilters(ControllerContext controllerContext, ActionDescriptor actionDescriptor);
}

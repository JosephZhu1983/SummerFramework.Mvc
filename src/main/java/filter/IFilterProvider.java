package filter;

import common.ActionDescriptor;
import common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IFilterProvider
{
    Iterable<Filter> getFilters(ControllerContext controllerContext, ActionDescriptor actionDescriptor);
}

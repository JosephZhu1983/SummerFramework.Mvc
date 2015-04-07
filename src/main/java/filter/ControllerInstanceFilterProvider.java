package filter;

import common.ActionDescriptor;
import common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerInstanceFilterProvider implements IFilterProvider
{
    public Iterable<Filter> getFilters(ControllerContext controllerContext, ActionDescriptor actionDescriptor)
    {
        return null;
    }
}

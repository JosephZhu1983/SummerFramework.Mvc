package net.summerframework.mvc.filter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IActionFilter extends IFilter
{
    void onActionExecuting(ActionExecutingContext filterContext);

    void onActionExecuted(ActionExecutedContext filterContext);
}

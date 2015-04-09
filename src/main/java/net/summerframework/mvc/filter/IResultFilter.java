package net.summerframework.mvc.filter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IResultFilter extends IFilter
{
    void onResultExecuting(ResultExecutingContext filterContext);

    void onResultExecuted(ResultExecutedContext filterContext);
}

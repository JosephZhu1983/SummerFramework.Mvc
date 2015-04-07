package filter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IResultFilter
{
    void onResultExecuting(ResultExecutingContext filterContext);

    void onResultExecuted(ResultExecutedContext filterContext);
}

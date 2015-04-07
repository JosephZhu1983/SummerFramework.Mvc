package filter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IExceptionFilter
{
    void onException(ExceptionContext filterContext);
}

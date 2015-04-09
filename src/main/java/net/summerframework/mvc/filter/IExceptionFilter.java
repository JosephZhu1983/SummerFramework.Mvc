package net.summerframework.mvc.filter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IExceptionFilter extends IFilter
{
    void onException(ExceptionContext filterContext);
}

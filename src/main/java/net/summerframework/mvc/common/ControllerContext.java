package net.summerframework.mvc.common;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerContext
{
    private HttpContext httpContext;

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public void setHttpContext(HttpContext httpContext)
    {
        this.httpContext = httpContext;
    }
}

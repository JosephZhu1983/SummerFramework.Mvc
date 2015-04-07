package common;

import javax.servlet.http.HttpServletRequest;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class HttpRequestContext
{
    private final HttpServletRequest request;

    public HttpRequestContext(HttpServletRequest request)
    {
        this.request = request;
    }
}

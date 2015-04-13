package net.summerframework.mvc.action;

import net.summerframework.mvc.common.HttpStatusCode;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class HttpNotFoundResult extends HttpStatusCodeResult
{
    public HttpNotFoundResult()
    {
        super(HttpStatusCode.NotFound);
    }
}

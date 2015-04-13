package net.summerframework.mvc.action;

import net.summerframework.mvc.common.ControllerContext;
import net.summerframework.mvc.common.HttpStatusCode;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class HttpStatusCodeResult extends ActionResult
{
    private HttpStatusCode httpStatusCode;

    public HttpStatusCodeResult(HttpStatusCode httpStatusCode)
    {
        this.httpStatusCode = httpStatusCode;
    }

    @Override
    public void executeResult(ControllerContext controllerContext)
    {
        controllerContext.getHttpContext().getResponse().setStatus(httpStatusCode.ordinal());
    }
}

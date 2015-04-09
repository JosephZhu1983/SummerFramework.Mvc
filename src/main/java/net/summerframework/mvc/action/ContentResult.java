package net.summerframework.mvc.action;

import net.summerframework.mvc.common.ControllerContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ContentResult extends ActionResult
{
    private final String content;
    private final String charset;
    private final String type;

    public ContentResult(String type, String charset, String content)
    {
        this.type = type;
        this.charset = charset;
        this.content = content;
    }

    public ContentResult(String content)
    {
        this("text/plain", "UTF-8", content);
    }

    @Override
    public void executeResult(ControllerContext controllerContext) throws ActionResultException
    {
        HttpServletResponse response = controllerContext.getHttpContext().getResponse();
        if (charset != null)
        {
            response.setCharacterEncoding(charset);
        }
        if (type != null)
        {
            response.setContentType(type);
        }
        if (content != null)
        {
            try
            {
                response.getWriter().write(content);
            }
            catch (IOException exception)
            {
                throw new ActionResultException("Can not write content to response output stream!", exception);
            }
        }
    }
}

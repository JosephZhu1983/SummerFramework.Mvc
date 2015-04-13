package net.summerframework.mvc.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.summerframework.mvc.common.ControllerContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class JsonResult extends ActionResult
{
    private final Object data;
    private final String charset;
    private final String type;
    private final JsonRequestBehavior jsonRequestBehavior;

    public JsonResult(String type, String charset, JsonRequestBehavior jsonRequestBehavior, Object data)
    {
        this.type = type;
        this.charset = charset;
        this.jsonRequestBehavior = jsonRequestBehavior;
        this.data = data;
    }

    public JsonResult(Object data)
    {
        this("application/json", "UTF-8", JsonRequestBehavior.AllowGet, data);
    }

    @Override
    public void executeResult(ControllerContext controllerContext) throws ActionResultException
    {
        if (controllerContext.getHttpContext().getRequest().getMethod().equalsIgnoreCase("get") && jsonRequestBehavior == JsonRequestBehavior.DenyGet)
        {
            throw new ActionResultException("");
        }

        HttpServletResponse response = controllerContext.getHttpContext().getResponse();
        if (charset != null)
        {
            response.setCharacterEncoding(charset);
        }
        if (type != null)
        {
            response.setContentType(type);
        }
        if (data != null)
        {
            try
            {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getWriter(), data);
            }
            catch (IOException exception)
            {
                throw new ActionResultException("Can not write content to response output stream!", exception);
            }
        }
    }
}

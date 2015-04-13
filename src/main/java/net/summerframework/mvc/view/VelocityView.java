package net.summerframework.mvc.view;

import net.summerframework.mvc.common.ViewContext;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class VelocityView implements IView
{
    private final VelocityEngine velocityEngine;
    private final String fileName;

    public VelocityView(VelocityEngine velocityEngine, String fileName)
    {
        this.velocityEngine = velocityEngine;
        this.fileName = fileName;
    }

    @Override
    public void render(ViewContext viewContext) throws ViewException
    {
        Template template = velocityEngine.getTemplate(fileName);
        VelocityContext context = new VelocityContext();
        context.put("model", viewContext.getViewData().getModel());
        context.put("data", viewContext.getViewData());
        context.put("temp", viewContext.getTempData());
        template.merge(context, viewContext.getWriter());
    }

    @Override
    public void release()
    {

    }
}

package net.summerframework.mvc.view;

import freemarker.template.*;
import net.summerframework.mvc.common.ViewContext;

import java.io.IOException;
import java.util.HashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class FreemarkerView implements IView
{
    private final Configuration configuration;
    private final String fileName;

    public FreemarkerView(Configuration configuration, String fileName)
    {
        this.configuration = configuration;
        this.fileName = fileName;
    }

    @Override
    public void render(ViewContext viewContext) throws ViewException
    {
        Template template = null;
        try
        {
            template = configuration.getTemplate(fileName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        HashMap<String, Object> context = new HashMap<>();
        context.put("model", viewContext.getViewData().getModel());
        context.put("data", viewContext.getViewData());
        context.put("temp", viewContext.getTempData());
        try
        {
            template.process(context, viewContext.getWriter());
        }
        catch (TemplateException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void release()
    {

    }
}

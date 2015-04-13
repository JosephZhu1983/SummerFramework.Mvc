package net.summerframework.mvc.view;

import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import net.summerframework.mvc.common.ViewContext;

import java.io.IOException;
import java.util.HashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class MustacheView implements IView
{
    private final MustacheFactory mustacheFactory;
    private final String fileName;

    public MustacheView(MustacheFactory mustacheFactory, String fileName)
    {
        this.mustacheFactory = mustacheFactory;
        this.fileName = fileName;
    }

    @Override
    public void render(ViewContext viewContext) throws ViewException
    {
        Mustache mustache = mustacheFactory.compile(fileName);
        try
        {
            HashMap<String, Object> context = new HashMap<>();
            context.put("model", viewContext.getViewData().getModel());
            context.put("data", viewContext.getViewData());
            context.put("temp", viewContext.getTempData());
            mustache.execute(viewContext.getWriter(), context).flush();
        }
        catch (IOException exception)
        {
            throw new ViewException("Got exception while calling mustache.execute()", exception);
        }
    }

    @Override
    public void release()
    {

    }
}

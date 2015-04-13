package net.summerframework.mvc.view;

import com.github.mustachejava.DefaultMustacheFactory;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class MustacheViewEngine extends TemplateFileViewEngine
{
    @Override
    protected String[] getFileExtensions()
    {
        return new String[]{".mustache"};
    }

    @Override
    protected IView getView(String fileName)
    {
        return new MustacheView(new DefaultMustacheFactory(), fileName);
    }
}

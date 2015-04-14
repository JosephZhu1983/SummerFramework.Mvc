package net.summerframework.mvc.view;

import freemarker.template.Configuration;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class FreemarkerViewEngine extends TemplateFileViewEngine
{
    private Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);

    public FreemarkerViewEngine()
    {
        configuration.setDefaultEncoding("UTF-8");
    }

    @Override
    protected String[] getFileExtensions()
    {
        return new String[]{".ftl"};
    }

    @Override
    protected IView getView(String fileName)
    {
        return new FreemarkerView(configuration, fileName);
    }
}

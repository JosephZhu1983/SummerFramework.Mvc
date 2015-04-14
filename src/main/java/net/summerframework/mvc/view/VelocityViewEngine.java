package net.summerframework.mvc.view;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class VelocityViewEngine extends TemplateFileViewEngine
{
    private VelocityEngine velocityEngine = new VelocityEngine();

    public VelocityViewEngine()
    {
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
    }

    @Override
    protected String[] getFileExtensions()
    {
        return new String[]{".vm"};
    }

    @Override
    protected IView getView(String viewName)
    {
        return new VelocityView(velocityEngine, viewName);
    }

}

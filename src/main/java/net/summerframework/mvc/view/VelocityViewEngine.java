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
    @Override
    protected String[] getFileExtensions()
    {
        return new String[]{".vm"};
    }

    @Override
    protected IView getView(String viewName)
    {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        return new VelocityView(velocityEngine, viewName);
    }

}

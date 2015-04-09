package net.summerframework.mvc.config;

import net.summerframework.mvc.controller.DefaultControllerFactory;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultConfig implements IConfig
{
    public void config(ConfigCenter configCenter)
    {
        configCenter.setControllerFactory(new DefaultControllerFactory());
        configCenter.removeAllRoutes();
        configCenter.addDefaultRoutePattern("default", "{controller??Home}/{action??Index}/{id?}");
    }
}

package net.summerframework.mvc.model;

import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IValueProviderFactory
{
    IValueProvider getValueProvider(ControllerContext controllerContext);
}

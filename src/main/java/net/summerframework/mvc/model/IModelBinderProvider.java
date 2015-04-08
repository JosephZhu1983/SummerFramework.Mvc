package net.summerframework.mvc.model;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IModelBinderProvider
{
    IModelBinder getModelBinder(Class modelType);
}

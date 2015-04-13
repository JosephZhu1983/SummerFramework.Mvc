package net.summerframework.mvc.view;

import net.summerframework.mvc.common.ViewContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IView
{
    void render(ViewContext viewContext) throws ViewException;

    void release();
}

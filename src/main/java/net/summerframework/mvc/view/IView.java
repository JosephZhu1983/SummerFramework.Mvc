package net.summerframework.mvc.view;

import net.summerframework.mvc.common.ViewContext;

import java.io.PrintWriter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IView
{
    void render(ViewContext viewContext, PrintWriter writer);
}

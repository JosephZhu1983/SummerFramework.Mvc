package net.summerframework.mvc.filter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public enum FilterScope
{
    Undefined(-1), Global(10), Controller(20), Action(30);

    private int scope = 0;

    FilterScope(int scope)
    {
        this.scope = scope;
    }
}

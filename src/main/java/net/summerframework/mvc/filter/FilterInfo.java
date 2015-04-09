package net.summerframework.mvc.filter;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class FilterInfo
{
    private Class<? extends IFilter> type;
    private FilterScope scope;
    private int order;

    public FilterInfo(Class<? extends IFilter> type, FilterScope scope, int order)
    {
        this.type = type;
        this.scope = scope;
        this.order = order;
    }

    public Class<? extends IFilter> getType()
    {
        return type;
    }

    public int getOrder()
    {
        return order;
    }

    public FilterScope getScope()
    {
        return scope;
    }
}

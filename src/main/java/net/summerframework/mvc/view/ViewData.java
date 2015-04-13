package net.summerframework.mvc.view;

import java.util.HashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ViewData extends HashMap<String, Object>
{
    private Object model;

    public Object getModel()
    {
        return model;
    }

    public void setModel(Object model)
    {
        this.model = model;
    }
}

package net.summerframework.mvc.routing;

import java.util.HashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class RouteData
{
    private static final String CONTROLLER_NAME_PLACEHOLDER = "controller";
    private static final String ACTION_NAME_PLACEHOLDER = "action";

    private final IRoute route;
    private final HashMap<String, String> values = new HashMap<>();

    public RouteData(IRoute route)
    {
        this.route = route;
    }

    public HashMap<String, String> getValues()
    {
        return values;
    }

    public String getControllerName()
    {
        return values.get(CONTROLLER_NAME_PLACEHOLDER);
    }

    public String getActionName()
    {
        return values.get(ACTION_NAME_PLACEHOLDER);
    }
}

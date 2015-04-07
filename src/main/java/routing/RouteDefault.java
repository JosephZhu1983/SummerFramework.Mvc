package routing;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class RouteDefault
{
    private boolean allowOptional = false;
    private String value;

    public RouteDefault(boolean allowOptional, String value)
    {
        this.allowOptional = allowOptional;
        this.value = value;
    }

    public static RouteDefault allowOptional()
    {
        return new RouteDefault(true, null);
    }

    public static RouteDefault setDefaultValue(String value)
    {
        return new RouteDefault(false, value);
    }
}
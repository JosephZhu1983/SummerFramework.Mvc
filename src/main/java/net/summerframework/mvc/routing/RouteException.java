package net.summerframework.mvc.routing;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class RouteException extends Exception
{
    public RouteException(String message)
    {
        super(message);
    }

    public RouteException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

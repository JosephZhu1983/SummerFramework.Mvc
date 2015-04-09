package net.summerframework.mvc.common;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerException extends Exception
{
    public ControllerException(String message)
    {
        super(message);
    }

    public ControllerException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

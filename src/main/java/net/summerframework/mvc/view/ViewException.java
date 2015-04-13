package net.summerframework.mvc.view;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ViewException extends Exception
{
    public ViewException(String message)
    {
        super(message);
    }

    public ViewException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

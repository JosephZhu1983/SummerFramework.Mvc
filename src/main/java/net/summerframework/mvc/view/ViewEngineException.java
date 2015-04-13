package net.summerframework.mvc.view;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ViewEngineException extends Exception
{
    public ViewEngineException(String message)
    {
        super(message);
    }

    public ViewEngineException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

package net.summerframework.mvc.action;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ActionMethodSelectorException extends Exception
{
    public ActionMethodSelectorException(String message)
    {
        super(message);
    }

    public ActionMethodSelectorException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

package net.summerframework.mvc.action;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ActionInvokerException extends Exception
{
    public ActionInvokerException(String message)
    {
        super(message);
    }

    public ActionInvokerException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

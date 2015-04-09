package net.summerframework.mvc.action;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ActionResultException extends Exception
{
    public ActionResultException(String message)
    {
        super(message);
    }

    public ActionResultException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

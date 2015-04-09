package net.summerframework.mvc.controller;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerFactoryException extends Exception
{
    public ControllerFactoryException(String message)
    {
        super(message);
    }

    public ControllerFactoryException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

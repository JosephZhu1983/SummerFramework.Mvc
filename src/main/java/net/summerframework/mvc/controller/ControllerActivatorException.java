package net.summerframework.mvc.controller;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ControllerActivatorException extends Exception
{
    public ControllerActivatorException(String message)
    {
        super(message);
    }

    public ControllerActivatorException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

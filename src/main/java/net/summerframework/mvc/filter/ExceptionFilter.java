package net.summerframework.mvc.filter;

import java.lang.annotation.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExceptionFilter
{
    Class<? extends IExceptionFilter> type();

    int order() default -1;
}

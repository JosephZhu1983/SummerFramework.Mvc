package net.summerframework.mvc.filter;

import java.lang.annotation.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
@Repeatable(ResultFilters.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ResultFilter
{
    Class<? extends IResultFilter> type();

    int order() default -1;
}

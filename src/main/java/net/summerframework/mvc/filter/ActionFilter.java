package net.summerframework.mvc.filter;

import java.lang.annotation.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
@Repeatable(ActionFilters.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ActionFilter
{
    Class<? extends IActionFilter> type();

    int order() default -1;
}

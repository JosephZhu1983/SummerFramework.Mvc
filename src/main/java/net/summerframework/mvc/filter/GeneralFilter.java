package net.summerframework.mvc.filter;

import java.lang.annotation.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
@Repeatable(GeneralFilters.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface GeneralFilter
{
    Class<? extends IGeneralFilter> type();

    int order() default -1;
}

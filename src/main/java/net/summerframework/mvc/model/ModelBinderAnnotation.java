package net.summerframework.mvc.model;

import java.lang.annotation.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelBinderAnnotation
{
    Class<IModelBinder> type();
}

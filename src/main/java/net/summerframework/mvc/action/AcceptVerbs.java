package net.summerframework.mvc.action;

import java.lang.annotation.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AcceptVerbs
{
    Class<? extends IActionMethodValidator> validator() default HttpVerbsValidator.class;

    String[] condition();
}

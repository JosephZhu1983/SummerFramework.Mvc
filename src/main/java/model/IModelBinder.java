package model;

import common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IModelBinder
{
    Object bindModel(ControllerContext controllerContext);
}

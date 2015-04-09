package net.summerframework.mvc.action;

import com.esotericsoftware.reflectasm.MethodAccess;
import net.summerframework.mvc.common.*;
import net.summerframework.mvc.controller.IController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultActionInvoker implements IActionInvoker
{
    private Map<String, ControllerDescriptor> controllerDescriptors = new ConcurrentHashMap<>();

    @Override
    public boolean invokeAction(ControllerContext controllerContext, String actionName) throws ActionInvokerException
    {
        ControllerDescriptor controllerDescriptor = getControllerDescriptor(controllerContext.getController().getClass());
        ActionDescriptor actionDescriptor = controllerDescriptor.findAction(controllerContext, actionName);
        MethodAccess methodAccess = MethodAccess.get(controllerContext.getController().getClass());
        ActionResult actionResult = (ActionResult) methodAccess.invoke(controllerContext.getController(), actionDescriptor.getActionName());
        try
        {
            actionResult.executeResult(controllerContext);
        }
        catch (ActionResultException exception)
        {
            throw new ActionInvokerException(String.format("Error executing action result : %s", actionResult.toString()), exception);
        }
        return true;
    }

    private ControllerDescriptor getControllerDescriptor(Class<? extends IController> controllerType)
    {
        return controllerDescriptors.putIfAbsent(controllerType.getName(), new ControllerDescriptor(controllerType));
    }
}

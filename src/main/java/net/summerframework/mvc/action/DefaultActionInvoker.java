package net.summerframework.mvc.action;

import com.esotericsoftware.reflectasm.MethodAccess;
import net.summerframework.mvc.common.*;
import net.summerframework.mvc.config.ConfigCenter;
import net.summerframework.mvc.controller.IController;
import net.summerframework.mvc.filter.*;

import java.util.Map;
import java.util.Stack;
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
    public void invokeAction(ControllerContext controllerContext, String actionName) throws ActionInvokerException
    {
        ControllerDescriptor controllerDescriptor = getControllerDescriptor(controllerContext.getController().getClass());
        ActionDescriptor actionDescriptor = null;
        try
        {
            actionDescriptor = controllerDescriptor.findAction(controllerContext, actionName);
        }
        catch (ActionMethodSelectorException exception)
        {
            throw new ActionInvokerException(String.format("Error invoking action : %s.%s", controllerDescriptor.getControllerName(), actionDescriptor.getActionName()), exception);
        }
        FilterProviders.Filters filters = ConfigCenter.getInstance().getFilterProviders().getFilters(controllerContext, actionDescriptor);

        ActionResult actionResult = null;
        Exception unhandledException = null;
        boolean canceled = false;

        ActionExecutingContext actionExecutingContext = new ActionExecutingContext(controllerContext, actionDescriptor);
        Stack<IActionFilter> actionFilters = new Stack<>();

        for (IActionFilter actionFilter : filters.getActionFilters())
        {
            try
            {
                actionFilter.onActionExecuting(actionExecutingContext);
                actionFilters.push(actionFilter);
                actionResult = actionExecutingContext.getActionResult();
                if (actionResult != null)
                {
                    canceled = true;
                    break;
                }
            }
            catch (RuntimeException exception)
            {
                unhandledException = exception;
                break;
            }
        }

        if (actionResult == null)
        {
            MethodAccess methodAccess = MethodAccess.get(controllerContext.getController().getClass());
            actionResult = (ActionResult) methodAccess.invoke(controllerContext.getController(), actionDescriptor.getActionName());
        }

        ActionExecutedContext actionExecutedContext = new ActionExecutedContext(controllerContext, actionDescriptor, canceled, unhandledException);

        while (!actionFilters.empty())
        {
            IActionFilter actionFilter = actionFilters.pop();

            try
            {
                if (actionExecutedContext.isExceptionHandled())
                {
                    unhandledException = null;
                }
                actionFilter.onActionExecuted(actionExecutedContext);
            }
            catch (RuntimeException exception)
            {
                unhandledException = exception;
                break;
            }
        }

        if (unhandledException != null)
        {
            ExceptionContext exceptionContext = new ExceptionContext(controllerContext, unhandledException);
            for (IExceptionFilter exceptionFilter : filters.getExceptionFilters())
            {
                exceptionFilter.onException(exceptionContext);
                if (exceptionContext.getActionResult() != null)
                {
                    actionResult = exceptionContext.getActionResult();
                }
                if (exceptionContext.isExceptionHandled())
                {
                    break;
                }
            }
        }

        if (unhandledException != null)
        {
            throw new ActionInvokerException(String.format("Error invoking action : %s.%s", controllerDescriptor.getControllerName(), actionDescriptor.getActionName()), unhandledException);
        }

        Stack<IResultFilter> resultFilters = new Stack<>();
        ResultExecutingContext resultExecutingContext = new ResultExecutingContext(controllerContext, actionResult);

        for (IResultFilter resultFilter : filters.getResultFilters())
        {
            try
            {
                resultFilter.onResultExecuting(resultExecutingContext);
            }
            catch (RuntimeException exception)
            {
                unhandledException = exception;
                break;
            }
            resultFilters.push(resultFilter);
            if (resultExecutingContext.isCancel())
            {
                break;
            }
        }

        if (actionResult != null)
        {
            try
            {
                actionResult.executeResult(controllerContext);
            }
            catch (ActionResultException exception)
            {
                unhandledException = exception;
            }
        }

        ResultExecutedContext resultExecutedContext = new ResultExecutedContext(controllerContext, resultExecutingContext.getActionResult(), resultExecutingContext.isCancel(), unhandledException);
        while (!resultFilters.empty())
        {
            IResultFilter resultFilter = resultFilters.pop();
            resultFilter.onResultExecuted(resultExecutedContext);
            if (resultExecutedContext.isExceptionHandled())
            {
                unhandledException = null;
            }
        }

        if (unhandledException != null)
        {
            throw new ActionInvokerException(String.format("Error invoking action : %s.%s", controllerDescriptor.getControllerName(), actionDescriptor.getActionName()), unhandledException);
        }
    }

    private ControllerDescriptor getControllerDescriptor(Class<? extends IController> controllerType)
    {
        return controllerDescriptors.putIfAbsent(controllerType.getName(), new ControllerDescriptor(controllerType));
    }
}

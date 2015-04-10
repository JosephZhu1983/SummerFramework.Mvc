package net.summerframework.mvc.action;

import net.summerframework.mvc.common.*;
import net.summerframework.mvc.config.ConfigCenter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ActionMethodSelector
{
    public ActionDescriptor findAction(ControllerContext controllerContext, ControllerDescriptor controllerDescriptor, String actionName) throws ActionMethodSelectorException
    {
        List<ActionDescriptor> matchedActions = controllerDescriptor.getActionDescriptors().stream()
                .filter(actionDescriptor -> actionName.equalsIgnoreCase(actionDescriptor.getActionName()) && ConfigCenter.getInstance().getActionMethodValidators().isValidForRequest(controllerContext, actionDescriptor.getAction()))
                .collect(Collectors.toList());

        if (matchedActions.size() == 0)
        {
            throw new ActionMethodSelectorException(String.format("Can not find action matched to name %s", actionName));
        }
        else if (matchedActions.size() == 1)
        {
            return matchedActions.get(0);
        }
        else
        {
            throw new ActionMethodSelectorException(String.format("Too many action matched to name %s, result : %s", actionName, matchedActions.stream()
                    .map(type -> type.getActionName()).reduce((a, b) -> a + "," + b).get()));
        }
    }
}

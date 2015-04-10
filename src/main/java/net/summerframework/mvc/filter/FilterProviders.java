package net.summerframework.mvc.filter;

import net.summerframework.mvc.common.ActionDescriptor;
import net.summerframework.mvc.common.ControllerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class FilterProviders extends ArrayList<IFilterProvider>
{
    private final Logger logger = LoggerFactory.getLogger(FilterProviders.class);

    private List<FilterInfo> getFiltersInfo(ControllerContext controllerContext, ActionDescriptor actionDescriptor)
    {
        List<FilterInfo> filtersInfo = new ArrayList<>();

        for (IFilterProvider filterProvider : this)
        {
            filtersInfo.addAll(filterProvider.getFiltersInfo(controllerContext, actionDescriptor));
        }

        return filtersInfo.stream()
                .sorted((a, b) -> Integer.compare(a.getScope().ordinal(), b.getScope().ordinal()))
                .sorted((a, b) -> Integer.compare(a.getOrder(), b.getOrder()))
                .collect(Collectors.toList());
    }

    public Filters getFilters(ControllerContext controllerContext, ActionDescriptor actionDescriptor)
    {
        Filters filters = new Filters();
        List<IFilter> allFilters = getFiltersInfo(controllerContext, actionDescriptor).stream().map(filterInfo ->
        {
            try
            {
                return filterInfo.getType().newInstance();
            }
            catch (Exception exception)
            {
                logger.warn(String.format("Can not create instance from filter type : %s", filterInfo.getType().getName()));
                return null;
            }

        }).filter(filter -> filter != null).collect(Collectors.toList());

        filters.actionFilters.addAll(allFilters.stream().filter(filter -> filter instanceof IActionFilter).map(filter -> (IActionFilter) filter).collect(Collectors.toList()));
        filters.resultFilters.addAll(allFilters.stream().filter(filter -> filter instanceof IResultFilter).map(filter -> (IResultFilter) filter).collect(Collectors.toList()));
        filters.exceptionFilters.addAll(allFilters.stream().filter(filter -> filter instanceof IExceptionFilter).map(filter -> (IExceptionFilter) filter).collect(Collectors.toList()));

        return filters;
    }

    public class Filters
    {
        List<IActionFilter> actionFilters = new ArrayList<>();
        List<IResultFilter> resultFilters = new ArrayList<>();
        List<IExceptionFilter> exceptionFilters = new ArrayList<>();

        public List<IActionFilter> getActionFilters()
        {
            return actionFilters;
        }

        public List<IResultFilter> getResultFilters()
        {
            return resultFilters;
        }

        public List<IExceptionFilter> getExceptionFilters()
        {
            return exceptionFilters;
        }
    }
}

package net.summerframework.mvc.view;

import net.summerframework.mvc.common.ControllerContext;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public abstract class TemplateFileViewEngine implements IViewEngine
{
    protected String[] templateFileLocations = new String[]
            {
                    "views/{controller}/{action}",
                    "{controller}/{action}"
            };

    protected abstract String[] getFileExtensions();

    protected abstract IView getView(String viewName);

    @Override
    public ViewEngineResult findPartialView(ControllerContext controllerContext, String partialViewName)
    {
        return null;
    }

    @Override
    public ViewEngineResult findView(ControllerContext controllerContext, String viewName, String masterName)
    {
        List<String> searchedLocations = new ArrayList<>();
        ServletContext servletContext = controllerContext.getHttpContext().getRequest().getServletContext();
        Path basePath = Paths.get(servletContext.getRealPath(""));

        for (String location : templateFileLocations)
        {
            try
            {
                String path = location.replace("{controller}", controllerContext.getRouteData().getControllerName().replace("{action}", controllerContext.getRouteData().getActionName())).toLowerCase();
                List<Path> matchedPaths = Files.list(basePath).filter(p -> p.toString().equalsIgnoreCase(path) && Stream.of(getFileExtensions()).anyMatch(ext -> path.endsWith(ext))).collect(Collectors.toList());
                if (matchedPaths.size() > 0)
                {
                    return new ViewEngineResult(getView(matchedPaths.get(0).toString()), this);
                }
                else
                {
                    searchedLocations.add(path);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return new ViewEngineResult(searchedLocations);
    }

    @Override
    public void releaseView(ControllerContext controllerContext, IView view)
    {
        view.release();
    }
}

package net.summerframework.mvc.routing;

import net.summerframework.mvc.common.HttpContext;

import java.util.*;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class DefaultRoute implements IRoute
{
    //{controller??Home}/{action??Index}/{id?}
    private final List<PatternSegment> patternSegments = new ArrayList<PatternSegment>();

    public DefaultRoute(String pattern) throws Exception
    {
        parsePattern(pattern);
    }

    private void parsePattern(String pattern) throws Exception
    {
        for (String segment : pattern.toLowerCase().split("/"))
        {
            PatternSegment patternSegment = new PatternSegment();
            if (segment.startsWith("{"))
            {
                if (segment.endsWith("}"))
                {
                    segment = segment.substring(1, segment.length() - 1);
                    if (segment.contains("??"))
                    {
                        patternSegment.placeHolderName = segment.substring(0, segment.indexOf("??"));
                        if (segment.indexOf("??") + 2 == segment.length())
                        {
                            throw new Exception(String.format("Invalid route pattern '%s', missing default value in '%s'", pattern, segment));
                        }
                        else
                        {
                            patternSegment.placeHolderDefaultValue = segment.substring(segment.indexOf("??") + 2);
                        }
                    }
                    else if (segment.endsWith("?"))
                    {
                        patternSegment.placeHolderName = segment.substring(0, segment.length() - 1);
                        patternSegment.allowOptional = true;
                    }
                }
                else
                {
                    throw new Exception(String.format("Invalid route pattern '%s', missing } in '%s'", pattern, segment));
                }
            }
            else
            {
                if (!segment.endsWith("}"))
                {
                    patternSegment.constPath = segment;
                }
                else
                {
                    throw new Exception(String.format("Invalid route pattern '%s', missing { in '%s'", pattern, segment));
                }
            }
            patternSegments.add(patternSegment);
        }
    }

    public RouteData getRouteData(HttpContext httpContext)
    {
        System.out.println(httpContext.getRequest().toString());
        String path = httpContext.getRequest().getPathInfo();
        //    /employee/detail/1
        return parsePath(path);
    }

    private RouteData parsePath(String path)
    {
        RouteData routeData = new RouteData(this);
        String[] pathSegments = path.toLowerCase().replaceFirst("/", "").split("/");
        for (int i = 0; i < patternSegments.size(); i++)
        {
            PatternSegment patternSegment = patternSegments.get(i);
            String pathSegment = pathSegments.length > i ? pathSegments[i] : "";
            if (patternSegment.constPath != null && patternSegment.constPath.equalsIgnoreCase(pathSegment))
            {

            }
            else if (!pathSegment.equals(""))
            {
                routeData.getValues().put(patternSegment.placeHolderName, pathSegment);
            }
            else if (pathSegment.equals("") && patternSegment.allowOptional)
            {

            }
            else if (pathSegment.equals("") && patternSegment.placeHolderDefaultValue != null)
            {
                routeData.getValues().put(patternSegment.placeHolderName, patternSegment.placeHolderDefaultValue);
            }
            else
            {
                return null;
            }
        }
        return routeData;
    }

    public VirtualPathData getVirtualPathData(HttpContext httpContext, HashMap<String, Object> values)
    {
        return null;
    }

    class PatternSegment
    {
        String constPath;
        String placeHolderName;
        boolean allowOptional;
        String placeHolderDefaultValue;
    }
}

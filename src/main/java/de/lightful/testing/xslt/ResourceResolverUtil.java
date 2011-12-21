package de.lightful.testing.xslt;

import java.net.URL;

public class ResourceResolverUtil {

  public static URL resolveResource(String href, String base, String[] resourceBasePaths) {
    URL resourceUrl;
    int basePathIndex = 0;
    do {
      resourceUrl = tryToResolveAgainstBase(href, base, resourceBasePaths[basePathIndex++]);
    } while (basePathIndex < resourceBasePaths.length && resourceUrl == null);
    return resourceUrl;
  }

  static URL tryToResolveAgainstBase(String href, String base, String resourceBasePath) {
    String adjustedBase;
    if (base.length() > 0) {
      adjustedBase = resourceBasePath + "/" + base;
    }
    else {
      adjustedBase = resourceBasePath;
    }

    final String resourcePath = adjustedBase + "/" + href;
    final URL resourceUrl = ResourceResolverUtil.class.getResource(resourcePath);
    return resourceUrl;
  }
}

package de.lightful.testing.xslt.internal;

import de.lightful.testing.xslt.SourceFactory;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BaseResourceUriResolver implements URIResolver {

  private String[] baseResourcePaths;

  private SourceFactory sourceFactory = ServiceRegistry.getServiceInstance(SourceFactory.class);

  public BaseResourceUriResolver(String[] resourceBasePaths) {
    this.baseResourcePaths = resourceBasePaths;
  }

  public Source resolve(String href, String base) throws TransformerException {
    final URL resourceUrl = ResourceResolverUtil.resolveResource(href, base, baseResourcePaths);
    if (resourceUrl == null) { return null; }
    try {
      return sourceFactory.createSourceFromFile(new File(resourceUrl.getFile()));
    }
    catch (IOException ioe) {
      // cannot resolve, let caller do resolution
      return null;
    }
  }
}

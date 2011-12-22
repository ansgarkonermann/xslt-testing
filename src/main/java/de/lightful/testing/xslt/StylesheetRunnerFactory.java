package de.lightful.testing.xslt;

import de.lightful.testing.xslt.internal.ServiceRegistry;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerException;

public class StylesheetRunnerFactory {

  public static StylesheetRunner runStylesheet(Templates stylesheet) throws TransformerException {
    return ServiceRegistry.getServiceInstance(StylesheetRunner.class, stylesheet);
  }
}

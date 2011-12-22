package de.lightful.testing.xslt;

import de.lightful.testing.xslt.internal.ConfigurableService;

import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerException;

public interface StylesheetRunner extends ConfigurableService<Templates> {

  String against(Source inputXml) throws TransformerException;
}

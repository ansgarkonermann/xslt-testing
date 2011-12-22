package de.lightful.testing.xslt.internal;

import de.lightful.testing.xslt.StylesheetRunner;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class StylesheetRunnerImpl implements StylesheetRunner {

  private Templates stylesheet;

  public void configure(Templates stylesheet) {
    this.stylesheet = stylesheet;
  }

  public String against(Source inputXml) throws TransformerException {
    StringWriter resultStringWriter = new StringWriter();
    Result transformationResult = new StreamResult(resultStringWriter);
    stylesheet.newTransformer().transform(inputXml, transformationResult);
    return resultStringWriter.toString();
  }
}

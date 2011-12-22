package de.lightful.testing.xslt.internal;

import de.lightful.testing.xslt.SourceFactory;
import org.testng.Assert;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URL;

public class SourceFactoryImpl implements SourceFactory {

  public Source createFromString(String inputXml) {
    StringReader inputStringReader = new StringReader(inputXml);
    return new StreamSource(inputStringReader);
  }

  public Source createSourceFromFile(File file) throws IOException {
    FileReader inputStringReader = new FileReader(file);
    return new StreamSource(inputStringReader);
  }

  public Source createSourceFromResourceUrl(URL resourcePath) throws IOException {
    InputStream inputStream = resourcePath.openStream();
    Assert.assertNotNull(inputStream, "Resource named " + resourcePath + " not found.");
    return new StreamSource(inputStream);
  }
}

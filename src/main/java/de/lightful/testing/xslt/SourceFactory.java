package de.lightful.testing.xslt;

import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface SourceFactory {

  Source createFromString(String inputXml);

  Source createSourceFromFile(File file) throws IOException;

  Source createSourceFromResourceUrl(URL resourcePath) throws IOException;
}

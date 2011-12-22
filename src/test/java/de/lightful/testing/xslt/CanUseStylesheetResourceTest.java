package de.lightful.testing.xslt;

import org.testng.annotations.Test;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;

import static de.lightful.testing.xml.XmlAssert.assertThat;
import static de.lightful.testing.xslt.StylesheetRunnerFactory.runStylesheet;
import static de.lightful.testing.xslt.TestXmlFactory.xmlTestCase;
import static de.lightful.testing.xslt.TestXmlFactory.xmlTests;

@Stylesheet(resource = "canUseStylesheetResource.xsl")
@ResourceBasePaths("/de/lightful/testing/xslt")
public class CanUseStylesheetResourceTest extends SaxonXsltTestBase {

  @Test
  public void testTemplateMatchConvertsToResults() throws TransformerException {
    Source source = sourceFactory().createFromString(xmlTests(xmlTestCase("a"), xmlTestCase("b"), xmlTestCase("c")));
    String xml = runStylesheet(getStylesheet()).against(source);
    assertThat(xml).isEquivalentTo("<results>" +
                                   "  <result>a+test</result>" +
                                   "  <result>b+test</result>" +
                                   "  <result>c+test</result>" +
                                   "</results>");
  }
}

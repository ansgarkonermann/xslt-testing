package de.lightful.testing.xslt;

import org.testng.annotations.Test;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;

import static de.lightful.testing.xml.XmlAssert.assertThat;
import static de.lightful.testing.xslt.StylesheetRunnerFactory.runStylesheet;
import static de.lightful.testing.xslt.TestXmlFactory.xmlTestCase;
import static de.lightful.testing.xslt.TestXmlFactory.xmlTests;

@StylesheetPerTestCase(xsltSnippet = "<xsl:value-of select='concat(\"foo//\", text())'/>")
public class CanRunStylesheetPerTestCaseTest extends SaxonXsltTestBase {

  @Test
  public void testFunctionIsCalledPerTestCase() throws TransformerException {
    Source source = sourceFactory().createFromString(xmlTests(xmlTestCase("a"), xmlTestCase("b"), xmlTestCase("c")));
    String xml = runStylesheet(getStylesheet()).against(source);
    assertThat(xml).isEquivalentTo("<results>" +
                                   "  <result>foo//a</result>" +
                                   "  <result>foo//b</result>" +
                                   "  <result>foo//c</result>" +
                                   "</results>");
  }
}

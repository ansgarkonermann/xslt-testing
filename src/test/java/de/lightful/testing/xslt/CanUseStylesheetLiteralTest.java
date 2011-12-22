package de.lightful.testing.xslt;

import org.testng.annotations.Test;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;

import static de.lightful.testing.xml.XmlAssert.assertThat;
import static de.lightful.testing.xslt.StylesheetRunnerFactory.runStylesheet;
import static de.lightful.testing.xslt.TestXmlFactory.xmlTestCase;
import static de.lightful.testing.xslt.TestXmlFactory.xmlTests;

@Stylesheet(literal = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                      "<xsl:stylesheet version='2.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>\n" +
                      "  <xsl:output method='xml' version='1.0' encoding='UTF-8' indent='yes'/>\n" +
                      "  <xsl:template match='/tests'>\n" +
                      "    <xsl:element name='results'>\n" +
                      "      <xsl:for-each select='testcase'>\n" +
                      "        <xsl:element name='result'><xsl:value-of select=\"concat('hello ', text())\"/></xsl:element>\n" +
                      "      </xsl:for-each>\n" +
                      "    </xsl:element>\n" +
                      "  </xsl:template>\n" +
                      "</xsl:stylesheet>\n")
public class CanUseStylesheetLiteralTest extends SaxonXsltTestBase {

  @Test
  public void testCalledFunctionCreatesResult() throws TransformerException {
    Source source = sourceFactory().createFromString(xmlTests(xmlTestCase("a"), xmlTestCase("b"), xmlTestCase("c")));
    String xml = runStylesheet(getStylesheet()).against(source);
    assertThat(xml).isEquivalentTo("<results>" +
                                   "  <result>hello a</result>" +
                                   "  <result>hello b</result>" +
                                   "  <result>hello c</result>" +
                                   "</results>");
  }
}

package de.lightful.testing.xslt;

import org.testng.annotations.Test;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;

import static de.lightful.testing.xml.XmlAssert.assertThat;
import static de.lightful.testing.xslt.StylesheetRunnerFactory.runStylesheet;
import static de.lightful.testing.xslt.TestXmlFactory.xmlTestCase;
import static de.lightful.testing.xslt.TestXmlFactory.xmlTests;

@StylesheetPerTestCase(
    xsltSnippet = "<xsl:call-template name='namedTemplate'><xsl:with-param name='param' select='text()'/></xsl:call-template>",
    imports = @ImportStylesheet("canUseStylesheetResource.xsl")
)
@ResourceBasePaths("/de/lightful/testing/xslt")
public class CanUseImportedResourceWithStylesheetPerTestCaseTest extends SaxonXsltTestBase {

  @Test
  public void testCalledTemplateFromImportedResourceCreatesResult() throws TransformerException {

    Source source = sourceFactory().createFromString(xmlTests(xmlTestCase("a"), xmlTestCase("b"), xmlTestCase("c")));
    String xml = runStylesheet(getStylesheet()).against(source);
    assertThat(xml).isEquivalentTo("<results>" +
                                   "  <result>a gnarf</result>" +
                                   "  <result>b gnarf</result>" +
                                   "  <result>c gnarf</result>" +
                                   "</results>");
  }
}

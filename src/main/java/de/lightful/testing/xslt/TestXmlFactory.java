package de.lightful.testing.xslt;

public class TestXmlFactory {

  public static String xmlTests(String... testCases) {

    StringBuilder builder = new StringBuilder();
    builder.append("<tests>");
    for (String testCase : testCases) {
      builder.append(testCase);
    }
    builder.append("</tests>");
    return builder.toString();
  }

  public static String xmlTestCase(String testCaseContent) {
    return "<testcase>" + testCaseContent + "</testcase>";
  }
}

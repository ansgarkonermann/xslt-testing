<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method='xml' version='1.0' encoding='UTF-8' indent='yes'/>

  <xsl:template match="/tests">
    <xsl:element name="results">
      <xsl:for-each select="testcase">
        <xsl:element name="result">
          <xsl:value-of select="concat(text(), '+test')"/>
        </xsl:element>
      </xsl:for-each>
    </xsl:element>
  </xsl:template>

  <xsl:template name="namedTemplate">
    <xsl:param name="param"/>
    <xsl:value-of select="concat($param, ' gnarf')"/>
  </xsl:template>

</xsl:stylesheet>

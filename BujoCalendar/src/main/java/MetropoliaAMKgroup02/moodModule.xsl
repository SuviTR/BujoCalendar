<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html"/>
  <xsl:template match="/">
    <html>
      <body>
        Dear <xsl:value-of select="root/user/firstname"/> <xsl:value-of select="root/user/lastname"/>
        Thank you for subscribing to our <i>weekly</i> newsletter.


      </body>
    </html>
  </xsl:template>


</xsl:stylesheet>
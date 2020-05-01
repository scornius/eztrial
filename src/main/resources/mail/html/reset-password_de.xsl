<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
<html>
    <body>
        Sehr geehrter <xsl:value-of select="/mail/name" />,<br/>
        Bitte setzen sie ihr Paswort hier zurück:
        <a><xsl:attribute name="href"><xsl:value-of select="/mail/url"/></xsl:attribute></a>.
    </body>
</html>
    </xsl:template>

</xsl:stylesheet>
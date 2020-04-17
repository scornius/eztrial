<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
Dear <xsl:value-of select="/mail/name" />,
Please reset your password:
<xsl:value-of select="/mail/url"/>.
    </xsl:template>

</xsl:stylesheet>
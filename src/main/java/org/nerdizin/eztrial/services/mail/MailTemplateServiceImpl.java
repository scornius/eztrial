package org.nerdizin.eztrial.services.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.StringWriter;

@Service
public class MailTemplateServiceImpl implements MailTemplateService {

    private final static Logger log = LoggerFactory.getLogger(MailTemplateServiceImpl.class);

    @Override
    public String resolveTemplate(final String template,
                                  final MailMode mailMode,
                                  final String inputXml) {

        final String resource = "/mail/"
                + mailMode.getFolder() + "/"
                + template + ".xsl";
        final StreamSource xslt = new StreamSource(
                MailTemplateServiceImpl.class.getResourceAsStream(resource));
        final StringSource input = new StringSource(inputXml);
        final StringWriter result = new StringWriter();

        final TransformerFactory factory = TransformerFactory.newInstance();
        try {
            final Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(input, new StreamResult(result));
        } catch (TransformerException e) {
            log.error(String.format("resolveTemplate failed: %s", resource), e);
        }
        return result.toString();
    }

}

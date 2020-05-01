package org.nerdizin.eztrial.services.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Locale;

@Service
public class MailTemplateServiceImpl implements MailTemplateService {

    private final static Logger log = LoggerFactory.getLogger(MailTemplateServiceImpl.class);
    private final static String XSL_EXTENSION = ".xsl";

    @Override
    public String applyTemplate(final String template,
                                final MailMode mailMode,
                                final String inputXml,
                                final Locale locale) {

        final StringSource input = new StringSource(inputXml);
        final StringWriter result = new StringWriter();

        final TransformerFactory factory = TransformerFactory.newInstance();
        try {
            final Transformer transformer = factory.newTransformer(resolveTemplate(template, mailMode, locale));
            transformer.transform(input, new StreamResult(result));
        } catch (TransformerException e) {
            log.error(String.format("resolveTemplate failed: %s", template), e);
        }
        return result.toString();
    }

    private Source resolveTemplate(final String template, final MailMode mailMode, final Locale locale) {

        final String path = "/mail/" + mailMode.getFolder() + "/";

        // try most specific: language + country
        String resource = path + template + "_" + locale.getLanguage() + "_" + locale.getCountry() + XSL_EXTENSION;
        InputStream is = MailTemplateServiceImpl.class.getResourceAsStream(resource);
        if (is != null) {
            return new StreamSource(is);
        }

        // try with language only
        resource = path + template + "_" + locale.getLanguage() + XSL_EXTENSION;
        is = MailTemplateServiceImpl.class.getResourceAsStream(resource);
        if (is != null) {
            return new StreamSource(is);
        }

        // fallback to global template
        resource = path + template + XSL_EXTENSION;
        is = MailTemplateServiceImpl.class.getResourceAsStream(resource);
        if (is != null) {
            return new StreamSource(is);
        }

        throw new IllegalArgumentException(String.format("Template %s not found", template));
    }

}

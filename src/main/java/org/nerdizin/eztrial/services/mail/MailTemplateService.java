package org.nerdizin.eztrial.services.mail;

import java.util.Locale;

public interface MailTemplateService {

    String applyTemplate(String template,
                         MailMode mailMode,
                         String inputXml,
                         Locale locale);
}

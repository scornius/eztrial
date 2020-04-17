package org.nerdizin.eztrial.services.mail;

public interface MailTemplateService {

    int MODE_HTML = 1;
    int MODE_TEXT = 2;

    String resolveTemplate(String template,
                           MailMode mailMode,
                           String inputXml);
}

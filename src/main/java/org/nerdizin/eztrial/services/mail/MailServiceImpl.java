package org.nerdizin.eztrial.services.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    private final static Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    @Override
    public void sendMail(final String senderEmail,
                         final String recipientEmail,
                         final String subject,
                         final String body) {

        log.info("mail for: {}, from: {}, subject: {}:", senderEmail, recipientEmail, subject);
        log.info(body);
    }

}

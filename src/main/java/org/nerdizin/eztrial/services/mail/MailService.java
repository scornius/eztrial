package org.nerdizin.eztrial.services.mail;

public interface MailService {
    void sendMail(String senderEmail,
                  String recipientEmail,
                  String subject,
                  String body);
}

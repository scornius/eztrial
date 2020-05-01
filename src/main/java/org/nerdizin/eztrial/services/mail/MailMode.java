package org.nerdizin.eztrial.services.mail;

public enum MailMode {

    HTML("html"),
    TEXT("text");

    private String folder;

    MailMode(String folder) {
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }
}

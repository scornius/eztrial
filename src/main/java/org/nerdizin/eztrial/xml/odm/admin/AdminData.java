package org.nerdizin.eztrial.xml.odm.admin;

import javax.xml.bind.annotation.XmlElement;


public class AdminData {

    @XmlElement(name = "User")
    private User user;

    @XmlElement(name = "Location")
    private Location location;

    @XmlElement(name = "SignatureDef")
    private SignatureDef signatureDef;


    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public SignatureDef getSignatureDef() {
        return signatureDef;
    }

    public void setSignatureDef(final SignatureDef signatureDef) {
        this.signatureDef = signatureDef;
    }
}

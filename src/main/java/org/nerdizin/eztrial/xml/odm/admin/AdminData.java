package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.odm.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AdminData {

    @XmlElement(name = "User", namespace = Namespaces.ODM)
    private User user;

    @XmlElement(name = "Location", namespace = Namespaces.ODM)
    private Location location;

    @XmlElement(name = "SignatureDef", namespace = Namespaces.ODM)
    private SignatureDef signatureDef;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SignatureDef getSignatureDef() {
        return signatureDef;
    }

    public void setSignatureDef(SignatureDef signatureDef) {
        this.signatureDef = signatureDef;
    }
}

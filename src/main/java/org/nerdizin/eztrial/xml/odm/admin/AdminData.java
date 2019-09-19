package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.odm.OdmElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class AdminData {

    @XmlElement(name = "User")
    private List<User> users;

    @XmlElement(name = "Location")
    private List<Location> locations;

    @XmlElement(name = "SignatureDef")
    private List<SignatureDef> signatureDefs;


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(final List<User> users) {
		this.users = users;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(final List<Location> locations) {
		this.locations = locations;
	}

	public List<SignatureDef> getSignatureDefs() {
		return signatureDefs;
	}

	public void setSignatureDefs(final List<SignatureDef> signatureDefs) {
		this.signatureDefs = signatureDefs;
	}
}

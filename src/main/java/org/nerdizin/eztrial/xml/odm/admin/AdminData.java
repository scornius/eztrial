package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.Namespaces;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;


public class AdminData {

    @XmlElement(name = "User")
    private List<User> users;

    @XmlElement(name = "Location")
    private List<Location> locations;

    @XmlElement(name = "SignatureDef")
    private List<SignatureDef> signatureDefs;

    @XmlElement(name = "Role", namespace = Namespaces.EZTRIAL)
	private List<Role> roles;


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(final List<User> users) {
		this.users = users;
	}

	public void addUser(final User user) {
		if (this.users == null) {
			this.users = new ArrayList<>();
		}
		this.users.add(user);
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(final List<Location> locations) {
		this.locations = locations;
	}

	public void addLocation(final Location location) {
		if (this.locations == null) {
			this.locations = new ArrayList<>();
		}
		this.locations.add(location);
	}

	public List<SignatureDef> getSignatureDefs() {
		return signatureDefs;
	}

	public void setSignatureDefs(final List<SignatureDef> signatureDefs) {
		this.signatureDefs = signatureDefs;
	}

	public void addSignatureDef(final SignatureDef signatureDef) {
		if (this.signatureDefs == null) {
			this.signatureDefs = new ArrayList<>();
		}
		this.signatureDefs.add(signatureDef);
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(final List<Role> roles) {
		this.roles = roles;
	}

	public void addRole(final Role role) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(role);
	}
}

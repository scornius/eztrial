package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.Namespaces;
import org.nerdizin.eztrial.xml.odm.base.OidElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.Set;
import java.util.TreeSet;

public class Role extends OidElement {

	@XmlElement(name = "Description", namespace = Namespaces.EZTRIAL)
	private String description;

	@XmlElement(name = "Privilege", namespace = Namespaces.EZTRIAL)
	private Set<Privilege> privileges;

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(final Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public void addPrivilege(final Privilege privilege) {
		if (this.privileges == null) {
			this.privileges = new TreeSet<>();
		}
		this.privileges.add(privilege);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
}

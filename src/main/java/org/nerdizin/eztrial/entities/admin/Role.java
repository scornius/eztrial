package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.base.OidEntity;
import org.nerdizin.eztrial.entities.base.OidNameEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "admin_roles")
public class Role extends OidNameEntity {

	@OneToMany(mappedBy = "role", orphanRemoval = true, cascade = CascadeType.MERGE)
	private List<Privilege> privileges;

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public Role setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
		return this;
	}

	public void addPrivilege(final Privilege privilege) {
		if (this.privileges == null) {
			this.privileges = new ArrayList<>();
		}
		privilege.setRole(this);
		this.privileges.add(privilege);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

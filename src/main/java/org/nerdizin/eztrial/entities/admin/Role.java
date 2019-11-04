package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "admin_roles")
public class Role extends BaseEntity {

	@Column(nullable = false)
	private String oid;

	@Column
	private String description;

	@OneToMany(mappedBy = "role", orphanRemoval = true, cascade = CascadeType.MERGE)
	private List<Privilege> privileges;


	public String getOid() {
		return oid;
	}

	public void setOid(final String oid) {
		this.oid = oid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(final List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public void addPrivilege(final Privilege privilege) {
		if (this.privileges == null) {
			this.privileges = new ArrayList<>();
		}
		privilege.setRole(this);
		this.privileges.add(privilege);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Role role = (Role) o;
		return oid.equals(role.oid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(oid);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

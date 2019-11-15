package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "admin_privileges")
public class Privilege extends BaseEntity implements Comparable<Privilege>, GrantedAuthority {

	@Column
	private String oid;

	@Column
	private boolean value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;


	@Override
	public String getAuthority() {
		return oid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(final String oid) {
		this.oid = oid;
	}

	public boolean getValue() {
		return value;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(final boolean value) {
		this.value = value;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(final Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int compareTo(final Privilege other) {

		if (other == null) {
			return -1;
		}

		return other.getOid().compareTo(getOid());
	}
}

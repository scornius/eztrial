package org.nerdizin.eztrial.entities.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class OidEntity extends BaseEntity {

	@Column(name = "oid", nullable = false, unique = true)
	private String oid;

	public String getOid() {
		return oid;
	}

	public void setOid(final String oid) {
		this.oid = oid;
	}
}

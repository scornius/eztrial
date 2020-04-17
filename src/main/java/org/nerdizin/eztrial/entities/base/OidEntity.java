package org.nerdizin.eztrial.entities.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.admin.Role;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

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

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final OidEntity oidEntity = (OidEntity) o;
		return oid.equals(oidEntity.oid);
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

package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.enums.LocationType;
import org.nerdizin.eztrial.entities.enums.LocationTypeConverter;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

	@Column(name = "oid", nullable = false, updatable = false, unique = true)
	private String oid;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "type", length = 10, nullable = false)
	@Convert(converter = LocationTypeConverter.class)
	private LocationType type;

	@Column(name = "is_active", nullable = false)
	private boolean active;

	@Column(name = "label", length = 100)
	private String label;

	@Column(name = "affix", length = 100)
	private String affix;

	@OneToOne
	private Address address;

	protected Location() {}

	public Location(final String oid, final String name, final LocationType type) {
		this.oid = oid;
		this.name = name;
		this.type = type;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(final String oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public LocationType getType() {
		return type;
	}

	public void setType(final LocationType type) {
		this.type = type;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public String getAffix() {
		return affix;
	}

	public void setAffix(final String affix) {
		this.affix = affix;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

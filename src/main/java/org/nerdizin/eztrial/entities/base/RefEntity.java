package org.nerdizin.eztrial.entities.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RefEntity extends BaseEntity {

	@Column(name = "mandatory")
	private boolean mandatory;

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(final boolean mandatory) {
		this.mandatory = mandatory;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

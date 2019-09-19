package org.nerdizin.eztrial.entities.base;

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
}

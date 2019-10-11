package org.nerdizin.eztrial.entities.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class RepeatingDefEntity extends DefEntity {

	@Column(name = "repeating")
	private boolean repeating;

	public boolean isRepeating() {
		return repeating;
	}

	public void setRepeating(final boolean repeating) {
		this.repeating = repeating;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

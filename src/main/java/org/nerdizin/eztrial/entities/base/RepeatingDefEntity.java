package org.nerdizin.eztrial.entities.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RepeatingDefEntity extends DefEntity {

	@Column(name = "repeating")
	private boolean repeating;

	public boolean isRepeating() {
		return repeating;
	}

	public void setRepeating(final boolean repeating) {
		this.repeating = repeating;
	}
}

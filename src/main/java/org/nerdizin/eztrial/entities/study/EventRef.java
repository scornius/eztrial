package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.RefEntity;

import javax.persistence.*;

@Entity
@Table(name = "def_event_ref")
public class EventRef extends RefEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "protocol_id")
	private Protocol protocol;

	@OneToOne
	private EventDef eventDef;

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(final Protocol protocol) {
		this.protocol = protocol;
	}

	public EventDef getEventDef() {
		return eventDef;
	}

	public void setEventDef(final EventDef eventDef) {
		this.eventDef = eventDef;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

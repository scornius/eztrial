package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.RefEntity;

import javax.persistence.*;

@Entity
@Table(name = "def_form_ref")
public class FormRef extends RefEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "def_event_id")
	private EventDef eventDef;

	@OneToOne
	private FormDef formDef;


	public EventDef getEventDef() {
		return eventDef;
	}

	public void setEventDef(final EventDef eventDef) {
		this.eventDef = eventDef;
	}

	public FormDef getFormDef() {
		return formDef;
	}

	public void setFormDef(final FormDef formDef) {
		this.formDef = formDef;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

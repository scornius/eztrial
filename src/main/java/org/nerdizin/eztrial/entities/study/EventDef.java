package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.DefEntity;
import org.nerdizin.eztrial.entities.base.OidNameEntity;
import org.nerdizin.eztrial.entities.base.RepeatingDefEntity;
import org.nerdizin.eztrial.entities.enums.EventType;
import org.nerdizin.eztrial.entities.enums.EventTypeConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "def_events")
public class EventDef extends RepeatingDefEntity {

	@Column
	@Convert(converter = EventTypeConverter.class)
	private EventType type;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "eventDef")
	private List<FormRef> formRefs;


	public EventType getType() {
		return type;
	}

	public void setType(final EventType type) {
		this.type = type;
	}

	public List<FormRef> getFormRefs() {
		return formRefs;
	}

	public void setFormRefs(final List<FormRef> formRefs) {
		this.formRefs = formRefs;
	}

	public void addFormRef(final FormRef formRef) {
		if (this.formRefs == null) {
			this.formRefs = new ArrayList<>();
		}
		this.formRefs.add(formRef);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

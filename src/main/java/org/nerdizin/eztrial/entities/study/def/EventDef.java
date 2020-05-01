package org.nerdizin.eztrial.entities.study.def;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.RepeatingDefEntity;
import org.nerdizin.eztrial.entities.enums.EventType;
import org.nerdizin.eztrial.entities.enums.EventTypeConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "def_events")
public class EventDef extends RepeatingDefEntity {

	@Column
	@Convert(converter = EventTypeConverter.class)
	private EventType type;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "eventDef")
	private List<FormRef> formRefs;

	@ElementCollection
	@MapKeyColumn(name = "language")
	@Column(name = "text")
	@CollectionTable(name="def_events_descriptions",
			joinColumns=@JoinColumn(name="id"),
			uniqueConstraints = @UniqueConstraint(columnNames={"id", "language"}))
	private Map<String,String> descriptions;


	public void addFormRef(final FormRef formRef) {
		if (this.formRefs == null) {
			this.formRefs = new ArrayList<>();
		}
		this.formRefs.add(formRef);
	}

	public void addDescription(final String language, final String text) {
		if (descriptions == null) {
			descriptions = new HashMap<>();
		}
		this.descriptions.put(language, text);
	}

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

	public Map<String,String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(final Map<String,String> descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

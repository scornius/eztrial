package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.adapter.EventTypeAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

public class StudyEventDef extends AbstractRepeatingDef {

	@XmlElement(name = "FormRef")
	private List<FormRef> formRefs;

	@XmlAttribute(name = "Type")
	@XmlJavaTypeAdapter(EventTypeAdapter.class)
	private EventType eventType;


	public List<FormRef> getFormRefs() {
		return formRefs;
	}

	public void setFormRefs(final List<FormRef> formRefs) {
		this.formRefs = formRefs;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(final EventType eventType) {
		this.eventType = eventType;
	}
}

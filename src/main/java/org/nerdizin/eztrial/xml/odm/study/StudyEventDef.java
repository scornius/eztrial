package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.adapter.EventTypeAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class StudyEventDef extends AbstractRepeatingDef {

	@XmlElement(name = "FormRef")
	private FormRef formRef;

	@XmlAttribute(name = "Type")
	@XmlJavaTypeAdapter(EventTypeAdapter.class)
	private EventType eventType;


	public FormRef getFormRef() {
		return formRef;
	}

	public void setFormRef(final FormRef formRef) {
		this.formRef = formRef;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(final EventType eventType) {
		this.eventType = eventType;
	}
}

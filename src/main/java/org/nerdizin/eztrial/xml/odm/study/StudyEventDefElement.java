package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.adapter.EventTypeAdapter;
import org.nerdizin.eztrial.xml.odm.base.RepeatingDefElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

public class StudyEventDefElement extends RepeatingDefElement {

	@XmlElement(name = "FormRef")
	private List<FormRefElement> formRefs;

	@XmlAttribute(name = "Type")
	@XmlJavaTypeAdapter(EventTypeAdapter.class)
	private EventType eventType;


	public List<FormRefElement> getFormRefs() {
		return formRefs;
	}

	public void setFormRefs(final List<FormRefElement> formRefs) {
		this.formRefs = formRefs;
	}

	public void addFormRef(final FormRefElement formRef) {
		if (this.formRefs == null) {
			this.formRefs = new ArrayList<>();
		}
		this.formRefs.add(formRef);
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(final EventType eventType) {
		this.eventType = eventType;
	}
}

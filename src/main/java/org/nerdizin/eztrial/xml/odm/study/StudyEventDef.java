package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.adapter.EventTypeAdapter;
import org.nerdizin.eztrial.xml.odm.base.RepeatingDefElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

public class StudyEventDef extends RepeatingDefElement {

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

	public void addFormRef(final FormRef formRef) {
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

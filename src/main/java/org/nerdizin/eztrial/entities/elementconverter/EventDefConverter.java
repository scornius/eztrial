package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.enums.EventType;
import org.nerdizin.eztrial.entities.study.EventDef;
import org.nerdizin.eztrial.entities.study.FormRef;
import org.nerdizin.eztrial.xml.odm.study.StudyEventDef;

public class EventDefConverter implements OdmElement2EntityConverter<StudyEventDef,EventDef> {

	@Override
	public EventDef convert2Entity(final StudyEventDef studyEventDef) {

		final EventDef result = new EventDef();
		result.setOid(studyEventDef.getOid());
		result.setName(studyEventDef.getName());
		result.setRepeating(studyEventDef.getRepeating());
		result.setType(EventType.getByCode(studyEventDef.getEventType().getCode()));

		return result;
	}

	@Override
	public StudyEventDef convert2Element(final EventDef eventDef) {

		final StudyEventDef result = new StudyEventDef();
		result.setOid(eventDef.getOid());
		result.setName(eventDef.getName());
		result.setRepeating(eventDef.isRepeating());
		result.setEventType(org.nerdizin.eztrial.xml.odm.study.EventType.fromCode(eventDef.getType().getCode()));

		if (eventDef.getFormRefs() != null) {
			for (final FormRef formRef : eventDef.getFormRefs()) {
				final org.nerdizin.eztrial.xml.odm.study.FormRef resultFormRef = new org.nerdizin.eztrial.xml.odm.study.FormRef();
				resultFormRef.setMandatory(formRef.isMandatory());
				resultFormRef.setFormOid(formRef.getFormDef().getOid());
				result.addFormRef(resultFormRef);
			}
		}

		return result;
	}
}

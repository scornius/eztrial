package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.enums.EventType;
import org.nerdizin.eztrial.entities.study.EventDef;
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
}

package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.enums.EventType;
import org.nerdizin.eztrial.entities.study.EventDef;
import org.nerdizin.eztrial.xml.odm.study.FormRef;
import org.nerdizin.eztrial.xml.odm.study.StudyEventDef;

public class EventDefConverter implements OdmElementToEntityConverter<StudyEventDef,EventDef> {

	@Override
	public EventDef convertToEntity(final StudyEventDef element) {

		final EventDef result = new EventDef();
		result.setOid(element.getOid());
		result.setName(element.getName());
		result.setRepeating(element.getRepeating());
		result.setType(EventType.getByCode(element.getEventType().getCode()));
		DescriptionConverterUtil.convertElementDescription(element, result);

		return result;
	}

	@Override
	public StudyEventDef convertToElement(final EventDef entity) {

		final StudyEventDef result = new StudyEventDef();
		result.setOid(entity.getOid());
		result.setName(entity.getName());
		result.setRepeating(entity.isRepeating());
		result.setEventType(org.nerdizin.eztrial.xml.odm.study.EventType.fromCode(entity.getType().getCode()));
		DescriptionConverterUtil.convertEntityDescription(entity, result);

		if (entity.getFormRefs() != null) {
			for (final org.nerdizin.eztrial.entities.study.FormRef formRef : entity.getFormRefs()) {
				final FormRef resultFormRef = new FormRef();
				resultFormRef.setMandatory(formRef.isMandatory());
				resultFormRef.setFormOid(formRef.getFormDef().getOid());
				result.addFormRef(resultFormRef);
			}
		}

		return result;
	}
}

package org.nerdizin.eztrial.entities.elementconverter.def;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.def.Protocol;
import org.nerdizin.eztrial.entities.study.def.EventRef;
import org.nerdizin.eztrial.xml.odm.study.def.Description;
import org.nerdizin.eztrial.xml.odm.study.def.StudyEventRef;
import org.nerdizin.eztrial.xml.odm.study.def.TranslatedText;

public class ProtocolConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.def.Protocol,Protocol> {

	@Override
	public Protocol convertToEntity(final org.nerdizin.eztrial.xml.odm.study.def.Protocol protocol) {

		final Protocol result = new Protocol();

		if (protocol.getDescription() != null) {
			for (final TranslatedText translatedText : protocol.getDescription().getTranslatedTexts()) {
				result.addTranslation(translatedText.getLanguage(), translatedText.getText());
			}
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.def.Protocol convertToElement(final Protocol protocol) {

		final org.nerdizin.eztrial.xml.odm.study.def.Protocol result =
				new org.nerdizin.eztrial.xml.odm.study.def.Protocol();

		if (protocol.getTranslations() != null) {
			final Description description = new Description();
			for (final String language : protocol.getTranslations().keySet()) {
				description.addTranslatedText(new TranslatedText(language, protocol.getTranslations().get(language)));
			}
			result.setDescription(description);
		}

		if (protocol.getEventRefs() != null) {
			for (final EventRef eventRef : protocol.getEventRefs()) {
				final StudyEventRef resultEventRef = new StudyEventRef();
				resultEventRef.setMandatory(eventRef.isMandatory());
				resultEventRef.setStudyEventOid(eventRef.getEventDef().getOid());
				result.addStudyEventRef(resultEventRef);
			}
		}

		return result;
	}
}

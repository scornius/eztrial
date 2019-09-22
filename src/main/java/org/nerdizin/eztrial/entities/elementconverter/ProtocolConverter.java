package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.Protocol;
import org.nerdizin.eztrial.xml.odm.study.Description;
import org.nerdizin.eztrial.xml.odm.study.StudyEventRef;
import org.nerdizin.eztrial.xml.odm.study.TranslatedText;

public class ProtocolConverter implements
		OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.Protocol,Protocol> {

	@Override
	public Protocol convert2Entity(final org.nerdizin.eztrial.xml.odm.study.Protocol protocol) {

		final Protocol result = new Protocol();

		if (protocol.getDescription() != null) {
			for (final TranslatedText translatedText : protocol.getDescription().getTranslatedTexts()) {
				result.addTranslation(translatedText.getLanguage(), translatedText.getText());
			}
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.Protocol convert2Element(final Protocol protocol) {

		final org.nerdizin.eztrial.xml.odm.study.Protocol result =
				new org.nerdizin.eztrial.xml.odm.study.Protocol();

		if (protocol.getTranslations() != null) {
			final Description description = new Description();
			for (final String language : protocol.getTranslations().keySet()) {
				description.addTranslatedText(new TranslatedText(language, protocol.getTranslations().get(language)));
			}
			result.setDescription(description);
		}

		if (protocol.getEventRefs() != null) {
			for (final org.nerdizin.eztrial.entities.study.EventRef eventRef : protocol.getEventRefs()) {
				final StudyEventRef resultEventRef = new StudyEventRef();
				resultEventRef.setMandatory(eventRef.isMandatory());
				resultEventRef.setStudyEventOid(eventRef.getEventDef().getOid());
				result.addStudyEventRef(resultEventRef);
			}
		}

		return result;
	}
}

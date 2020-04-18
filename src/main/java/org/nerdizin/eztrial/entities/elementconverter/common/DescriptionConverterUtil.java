package org.nerdizin.eztrial.entities.elementconverter.common;

import org.nerdizin.eztrial.entities.base.DefEntity;
import org.nerdizin.eztrial.xml.odm.base.DefElement;
import org.nerdizin.eztrial.xml.odm.study.def.Description;
import org.nerdizin.eztrial.xml.odm.study.def.TranslatedText;

public class DescriptionConverterUtil {

	public static void convertEntityDescription(final DefEntity defEntity, final DefElement defElement) {
		if (defEntity.getDescriptions() != null) {
			final Description description = new Description();
			for (final String language : defEntity.getDescriptions().keySet()) {
				description.addTranslatedText(new TranslatedText(language, defEntity.getDescriptions().get(language)));
			}
			defElement.setDescription(description);
		}
	}

	public static void convertElementDescription(final DefElement defElement, final DefEntity defEntity) {
		if (defElement.getDescription() != null) {
			for (final TranslatedText translatedText : defElement.getDescription().getTranslatedTexts()) {
				defEntity.addDescription(translatedText.getLanguage(), translatedText.getText());
			}
		}
	}
}

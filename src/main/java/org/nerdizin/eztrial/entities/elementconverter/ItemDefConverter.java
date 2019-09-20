package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.enums.DataType;
import org.nerdizin.eztrial.entities.study.ItemDef;
import org.nerdizin.eztrial.xml.odm.study.Question;
import org.nerdizin.eztrial.xml.odm.study.TranslatedText;

public class ItemDefConverter implements
		OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.ItemDef,ItemDef> {

	@Override
	public ItemDef convert2Entity(final org.nerdizin.eztrial.xml.odm.study.ItemDef itemDef) {

		final ItemDef result = new ItemDef();
		result.setOid(itemDef.getOid());
		result.setName(itemDef.getName());
		result.setDataType(DataType.fromCode(itemDef.getDataType().getCode()));

		if (itemDef.getQuestion().getTranslatedTexts() != null) {
			for (final TranslatedText translatedText : itemDef.getQuestion().getTranslatedTexts()) {
				result.addTranslation(translatedText.getLanguage(), translatedText.getText());
			}
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.ItemDef convert2Element(final ItemDef itemDef) {

		final org.nerdizin.eztrial.xml.odm.study.ItemDef result = new org.nerdizin.eztrial.xml.odm.study.ItemDef();
		result.setOid(itemDef.getOid());
		result.setName(itemDef.getName());
		result.setDataType(org.nerdizin.eztrial.xml.odm.study.DataType.fromCode(itemDef.getDataType().getCode()));

		if (itemDef.getTranslations() != null) {
			final Question question = new Question();
			for (final String language : itemDef.getTranslations().keySet()) {
				question.addTranslatedText(new TranslatedText(language, itemDef.getTranslations().get(language)));
			}
			result.setQuestion(question);
		}

		return result;
	}
}

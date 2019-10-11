package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.enums.DataType;
import org.nerdizin.eztrial.entities.study.ItemDef;
import org.nerdizin.eztrial.xml.odm.study.Question;
import org.nerdizin.eztrial.xml.odm.study.TranslatedText;

public class ItemDefConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.ItemDef,ItemDef> {

	@Override
	public ItemDef convertToEntity(final org.nerdizin.eztrial.xml.odm.study.ItemDef element) {

		final ItemDef result = new ItemDef();
		result.setOid(element.getOid());
		result.setName(element.getName());
		result.setDataType(DataType.fromCode(element.getDataType().getCode()));
		DescriptionConverterUtil.convertElementDescription(element, result);

		if (element.getQuestion().getTranslatedTexts() != null) {
			for (final TranslatedText translatedText : element.getQuestion().getTranslatedTexts()) {
				result.addQuestion(translatedText.getLanguage(), translatedText.getText());
			}
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.ItemDef convertToElement(final ItemDef entity) {

		final org.nerdizin.eztrial.xml.odm.study.ItemDef result = new org.nerdizin.eztrial.xml.odm.study.ItemDef();
		result.setOid(entity.getOid());
		result.setName(entity.getName());
		result.setDataType(org.nerdizin.eztrial.xml.odm.study.DataType.fromCode(entity.getDataType().getCode()));
		DescriptionConverterUtil.convertEntityDescription(entity, result);

		if (entity.getQuestions() != null) {
			final Question question = new Question();
			for (final String language : entity.getQuestions().keySet()) {
				question.addTranslatedText(new TranslatedText(language, entity.getQuestions().get(language)));
			}
			result.setQuestion(question);
		}

		return result;
	}
}

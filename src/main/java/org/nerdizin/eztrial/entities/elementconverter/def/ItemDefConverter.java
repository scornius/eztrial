package org.nerdizin.eztrial.entities.elementconverter.def;

import org.nerdizin.eztrial.entities.elementconverter.common.DescriptionConverterUtil;
import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.enums.DataType;
import org.nerdizin.eztrial.entities.study.def.ItemDef;
import org.nerdizin.eztrial.xml.odm.study.def.Question;
import org.nerdizin.eztrial.xml.odm.study.def.TranslatedText;

public class ItemDefConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.def.ItemDef,ItemDef> {

	@Override
	public ItemDef convertToEntity(final org.nerdizin.eztrial.xml.odm.study.def.ItemDef element) {

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
	public org.nerdizin.eztrial.xml.odm.study.def.ItemDef convertToElement(final ItemDef entity) {

		final org.nerdizin.eztrial.xml.odm.study.def.ItemDef result = new org.nerdizin.eztrial.xml.odm.study.def.ItemDef();
		result.setOid(entity.getOid());
		result.setName(entity.getName());
		result.setDataType(org.nerdizin.eztrial.xml.odm.study.def.DataType.fromCode(entity.getDataType().getCode()));
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

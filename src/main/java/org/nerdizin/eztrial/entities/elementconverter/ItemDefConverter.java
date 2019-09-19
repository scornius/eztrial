package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.enums.DataType;
import org.nerdizin.eztrial.entities.study.ItemDef;
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
}

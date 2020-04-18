package org.nerdizin.eztrial.entities.elementconverter.def;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.def.MeasurementUnit;
import org.nerdizin.eztrial.xml.odm.study.def.Symbol;
import org.nerdizin.eztrial.xml.odm.study.def.TranslatedText;

public class MeasurementUnitConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.def.MeasurementUnit,MeasurementUnit> {

	@Override
	public MeasurementUnit convertToEntity(final org.nerdizin.eztrial.xml.odm.study.def.MeasurementUnit measurementUnit) {

		final MeasurementUnit result = new MeasurementUnit();
		result.setOid(measurementUnit.getOid());
		result.setName(measurementUnit.getName());

		if (measurementUnit.getSymbol() != null) {
			if (measurementUnit.getSymbol().getTranslatedTexts() != null) {
				for (final TranslatedText translatedText : measurementUnit.getSymbol().getTranslatedTexts()) {
					result.addTranslation(translatedText.getLanguage(), translatedText.getText());
				}
			}
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.def.MeasurementUnit convertToElement(final MeasurementUnit measurementUnit) {

		final org.nerdizin.eztrial.xml.odm.study.def.MeasurementUnit result =
				new org.nerdizin.eztrial.xml.odm.study.def.MeasurementUnit();
		result.setOid(measurementUnit.getOid());
		result.setName(measurementUnit.getName());

		if (measurementUnit.getTranslations() != null) {
			final Symbol symbol = new Symbol();
			for (final String language : measurementUnit.getTranslations().keySet()) {
				symbol.addTranslatedText(new TranslatedText(language, measurementUnit.getTranslations().get(language)));
			}
			result.setSymbol(symbol);
		}

		return result;
	}
}

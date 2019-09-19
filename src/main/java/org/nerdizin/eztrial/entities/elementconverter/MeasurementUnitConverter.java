package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.MeasurementUnit;
import org.nerdizin.eztrial.xml.odm.study.TranslatedText;

public class MeasurementUnitConverter implements
		OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.MeasurementUnit,MeasurementUnit> {

	@Override
	public MeasurementUnit convert2Entity(final org.nerdizin.eztrial.xml.odm.study.MeasurementUnit measurementUnit) {

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
}

package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class BasicDefinitions {

	@XmlElement(name = "MeasurementUnit")
	private List<MeasurementUnit> measurementUnits;


	public List<MeasurementUnit> getMeasurementUnits() {
		return measurementUnits;
	}

	public void setMeasurementUnits(final List<MeasurementUnit> measurementUnits) {
		this.measurementUnits = measurementUnits;
	}
}

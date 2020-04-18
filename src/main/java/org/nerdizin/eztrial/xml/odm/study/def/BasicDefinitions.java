package org.nerdizin.eztrial.xml.odm.study.def;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
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

	public void addMeasurementUnit(final MeasurementUnit measurementUnit) {
		if (this.measurementUnits == null) {
			this.measurementUnits = new ArrayList<>();
		}
		this.measurementUnits.add(measurementUnit);
	}
}

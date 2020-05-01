package org.nerdizin.eztrial.xml.odm.study.def;

import org.nerdizin.eztrial.xml.odm.base.OidNameElement;

import javax.xml.bind.annotation.XmlElement;

public class MeasurementUnit extends OidNameElement {

	@XmlElement(name = "Symbol")
	private Symbol symbol;

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(final Symbol symbol) {
		this.symbol = symbol;
	}
}

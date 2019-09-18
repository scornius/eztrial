package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class MeasurementUnit {

	@XmlAttribute(name = "OID")
	private String oid;

	@XmlAttribute(name = "Name")
	private String name;

	@XmlElement(name = "Symbol")
	private Symbol symbol;


	public String getOid() {
		return oid;
	}

	public void setOid(final String oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(final Symbol symbol) {
		this.symbol = symbol;
	}
}

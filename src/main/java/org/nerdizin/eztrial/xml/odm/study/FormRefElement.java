package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.base.RefElement;

import javax.xml.bind.annotation.XmlAttribute;

public class FormRefElement extends RefElement {

	@XmlAttribute(name = "FormOID")
	private String formOid;


	public String getFormOid() {
		return formOid;
	}

	public void setFormOid(final String formOid) {
		this.formOid = formOid;
	}
}

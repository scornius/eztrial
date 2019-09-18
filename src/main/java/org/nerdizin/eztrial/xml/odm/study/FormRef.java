package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlAttribute;

public class FormRef extends AbstractRef {

	@XmlAttribute(name = "FormOID")
	private String formOid;


	public String getFormOid() {
		return formOid;
	}

	public void setFormOid(final String formOid) {
		this.formOid = formOid;
	}
}

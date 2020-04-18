package org.nerdizin.eztrial.xml.odm.study.def;

import org.nerdizin.eztrial.xml.odm.base.RefElement;

import javax.xml.bind.annotation.XmlAttribute;

public class ItemRefElement extends RefElement {

	@XmlAttribute(name = "ItemOID")
	private String itemOid;


	public String getItemOid() {
		return itemOid;
	}

	public void setItemOid(final String itemOid) {
		this.itemOid = itemOid;
	}
}

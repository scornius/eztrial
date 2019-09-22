package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.base.RefElement;

import javax.xml.bind.annotation.XmlAttribute;

public class ItemGroupRefElement extends RefElement {

	@XmlAttribute(name = "ItemGroupOID")
	private String itemGroupOid;


	public String getItemGroupOid() {
		return itemGroupOid;
	}

	public void setItemGroupOid(final String itemGroupOid) {
		this.itemGroupOid = itemGroupOid;
	}
}

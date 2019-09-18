package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlAttribute;

public class ItemGroupRef extends AbstractRef {

	@XmlAttribute(name = "ItemGroupOID")
	private String itemGroupOid;


	public String getItemGroupOid() {
		return itemGroupOid;
	}

	public void setItemGroupOid(final String itemGroupOid) {
		this.itemGroupOid = itemGroupOid;
	}
}

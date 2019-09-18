package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlAttribute;

public class ItemRef extends AbstractRef {

	@XmlAttribute(name = "ItemOID")
	private String itemOid;


	public String getItemOid() {
		return itemOid;
	}

	public void setItemOid(final String itemOid) {
		this.itemOid = itemOid;
	}
}

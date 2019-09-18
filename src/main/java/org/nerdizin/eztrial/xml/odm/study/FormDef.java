package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;

public class FormDef extends AbstractRepeatingDef {

	@XmlElement(name = "ItemGroupRef")
	private ItemGroupRef itemGroupRef;


	public ItemGroupRef getItemGroupRef() {
		return itemGroupRef;
	}

	public void setItemGroupRef(final ItemGroupRef itemGroupRef) {
		this.itemGroupRef = itemGroupRef;
	}
}

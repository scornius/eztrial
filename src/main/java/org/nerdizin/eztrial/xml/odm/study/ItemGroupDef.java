package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;

public class ItemGroupDef extends AbstractRepeatingDef {

	@XmlElement(name = "ItemRef")
    private ItemRef itemRef;


	public ItemRef getItemRef() {
		return itemRef;
	}

	public void setItemRef(final ItemRef itemRef) {
		this.itemRef = itemRef;
	}
}

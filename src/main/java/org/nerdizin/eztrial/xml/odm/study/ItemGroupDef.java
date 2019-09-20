package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class ItemGroupDef extends AbstractRepeatingDef {

	@XmlElement(name = "ItemRef")
    private List<ItemRef> itemRefs;


	public List<ItemRef> getItemRefs() {
		return itemRefs;
	}

	public void setItemRefs(final List<ItemRef> itemRefs) {
		this.itemRefs = itemRefs;
	}

	public void addItemRef(final ItemRef itemRef) {
		if (this.itemRefs == null) {
			this.itemRefs = new ArrayList<>();
		}
		this.itemRefs.add(itemRef);
	}
}

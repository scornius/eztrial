package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.base.RepeatingDefElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class ItemGroupDef extends RepeatingDefElement {

	@XmlElement(name = "ItemRef")
    private List<ItemRefElement> itemRefs;


	public List<ItemRefElement> getItemRefs() {
		return itemRefs;
	}

	public void setItemRefs(final List<ItemRefElement> itemRefs) {
		this.itemRefs = itemRefs;
	}

	public void addItemRef(final ItemRefElement itemRef) {
		if (this.itemRefs == null) {
			this.itemRefs = new ArrayList<>();
		}
		this.itemRefs.add(itemRef);
	}
}

package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.base.RepeatingDefElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FormDefElement extends RepeatingDefElement {

	@XmlElement(name = "ItemGroupRef")
	private List<ItemGroupRefElement> itemGroupRefs;


	public List<ItemGroupRefElement> getItemGroupRefs() {
		return itemGroupRefs;
	}

	public void setItemGroupRefs(final List<ItemGroupRefElement> itemGroupRefs) {
		this.itemGroupRefs = itemGroupRefs;
	}

	public void addItemGroupRef(final ItemGroupRefElement itemGroupRef) {
		if (this.itemGroupRefs == null) {
			this.itemGroupRefs = new ArrayList<>();
		}
		this.itemGroupRefs.add(itemGroupRef);
	}
}

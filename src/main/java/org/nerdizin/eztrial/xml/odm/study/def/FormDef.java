package org.nerdizin.eztrial.xml.odm.study.def;

import org.nerdizin.eztrial.xml.odm.base.RepeatingDefElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FormDef extends RepeatingDefElement {

	@XmlElement(name = "ItemGroupRef")
	private List<ItemGroupRef> itemGroupRefs;


	public List<ItemGroupRef> getItemGroupRefs() {
		return itemGroupRefs;
	}

	public void setItemGroupRefs(final List<ItemGroupRef> itemGroupRefs) {
		this.itemGroupRefs = itemGroupRefs;
	}

	public void addItemGroupRef(final ItemGroupRef itemGroupRef) {
		if (this.itemGroupRefs == null) {
			this.itemGroupRefs = new ArrayList<>();
		}
		this.itemGroupRefs.add(itemGroupRef);
	}
}

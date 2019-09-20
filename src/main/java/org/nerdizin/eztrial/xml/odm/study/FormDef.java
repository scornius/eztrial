package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class FormDef extends AbstractRepeatingDef {

	@XmlElement(name = "ItemGroupRef")
	private List<ItemGroupRef> itemGroupRefs;


	public List<ItemGroupRef> getItemGroupRefs() {
		return itemGroupRefs;
	}

	public void setItemGroupRefs(final List<ItemGroupRef> itemGroupRefs) {
		this.itemGroupRefs = itemGroupRefs;
	}
}

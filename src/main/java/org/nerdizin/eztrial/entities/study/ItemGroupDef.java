package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.DefEntity;
import org.nerdizin.eztrial.entities.base.OidNameEntity;
import org.nerdizin.eztrial.entities.base.RepeatingDefEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "def_item_groups")
public class ItemGroupDef extends RepeatingDefEntity {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "itemGroupDef")
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

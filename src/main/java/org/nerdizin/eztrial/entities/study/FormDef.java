package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.DefEntity;
import org.nerdizin.eztrial.entities.base.OidNameEntity;
import org.nerdizin.eztrial.entities.base.RepeatingDefEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "def_forms")
public class FormDef extends RepeatingDefEntity {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "formDef")
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

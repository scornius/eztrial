package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.RefEntity;

import javax.persistence.*;

@Entity
@Table(name = "def_item_ref")
public class ItemRef extends RefEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "def_item_group_id")
	private ItemGroupDef itemGroupDef;

	@OneToOne
	private ItemDef itemDef;


	public ItemGroupDef getItemGroupDef() {
		return itemGroupDef;
	}

	public void setItemGroupDef(final ItemGroupDef itemGroupDef) {
		this.itemGroupDef = itemGroupDef;
	}

	public ItemDef getItemDef() {
		return itemDef;
	}

	public void setItemDef(final ItemDef itemDef) {
		this.itemDef = itemDef;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

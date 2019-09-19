package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.RefEntity;

import javax.persistence.*;

@Entity
@Table(name = "def_item_group_ref")
public class ItemGroupRef extends RefEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "def_form_id")
	private FormDef formDef;

	@OneToOne
	private ItemGroupDef itemGroupDef;


	public FormDef getFormDef() {
		return formDef;
	}

	public void setFormDef(final FormDef formDef) {
		this.formDef = formDef;
	}

	public ItemGroupDef getItemGroupDef() {
		return itemGroupDef;
	}

	public void setItemGroupDef(final ItemGroupDef itemGroupDef) {
		this.itemGroupDef = itemGroupDef;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

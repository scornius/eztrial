package org.nerdizin.eztrial.entities.study.def;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidNameEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "def_mdvs")
public class MetaDataVersion extends OidNameEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "study_id")
	private Study study;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "metaDataVersion")
	private Protocol protocol;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "metaDataVersion")
	private List<EventDef> eventDefs;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "metaDataVersion")
	private List<FormDef> formDefs;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "metaDataVersion")
	private List<ItemGroupDef> itemGroupDefs;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "metaDataVersion")
	private List<ItemDef> itemDefs;

	public void addEventDef(final EventDef eventDef) {
		if (this.eventDefs == null) {
			this.eventDefs = new ArrayList<>();
		}
		this.eventDefs.add(eventDef);
	}

	public void addFormDef(final FormDef formDef) {
		if (this.formDefs == null) {
			this.formDefs = new ArrayList<>();
		}
		this.formDefs.add(formDef);
	}

	public void addItemGroupDef(final ItemGroupDef itemGroupDef) {
		if (this.itemGroupDefs == null) {
			this.itemGroupDefs = new ArrayList<>();
		}
		this.itemGroupDefs.add(itemGroupDef);
	}

	public void addItemDef(final ItemDef itemDef) {
		if (this.itemDefs == null) {
			this.itemDefs = new ArrayList<>();
		}
		this.itemDefs.add(itemDef);
	}

	public EventDef findEventDefByOid(final String oid) {
		for (final EventDef eventDef : this.eventDefs) {
			if (eventDef.getOid().equals(oid)) {
				return eventDef;
			}
		}
		throw new IllegalArgumentException(String.format("No EventDef found with oid %s", oid));
	}

	public FormDef findFormDefByOid(final String oid) {
		for (final FormDef formDef : this.formDefs) {
			if (formDef.getOid().equals(oid)) {
				return formDef;
			}
		}
		throw new IllegalArgumentException(String.format("No FormDef found with oid %s", oid));
	}

	public ItemGroupDef findItemGroupDefByOid(final String oid) {
		for (final ItemGroupDef itemGroupDef : this.itemGroupDefs) {
			if (itemGroupDef.getOid().equals(oid)) {
				return itemGroupDef;
			}
		}
		throw new IllegalArgumentException(String.format("No ItemGroupDef found with oid %s", oid));
	}

	public ItemDef findItemDefByOid(final String oid) {
		for (final ItemDef itemDef : this.itemDefs) {
			if (itemDef.getOid().equals(oid)) {
				return itemDef;
			}
		}
		throw new IllegalArgumentException(String.format("No ItemDef found with oid %s", oid));
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(final Study study) {
		this.study = study;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(final Protocol protocol) {
		this.protocol = protocol;
	}

	public List<EventDef> getEventDefs() {
		return eventDefs;
	}

	public void setEventDefs(final List<EventDef> eventDefs) {
		this.eventDefs = eventDefs;
	}

	public List<FormDef> getFormDefs() {
		return formDefs;
	}

	public void setFormDefs(final List<FormDef> formDefs) {
		this.formDefs = formDefs;
	}

	public List<ItemGroupDef> getItemGroupDefs() {
		return itemGroupDefs;
	}

	public void setItemGroupDefs(final List<ItemGroupDef> itemGroupDefs) {
		this.itemGroupDefs = itemGroupDefs;
	}

	public List<ItemDef> getItemDefs() {
		return itemDefs;
	}

	public void setItemDefs(final List<ItemDef> itemDefs) {
		this.itemDefs = itemDefs;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

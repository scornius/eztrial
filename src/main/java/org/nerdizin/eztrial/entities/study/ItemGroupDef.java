package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidNameEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "def_item_groups")
public class ItemGroupDef extends OidNameEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "mdv_id")
	private MetaDataVersion metaDataVersion;

	@Column(name = "repeating")
	private boolean repeating;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "itemGroupDef")
	private List<ItemRef> itemRefs;


	public MetaDataVersion getMetaDataVersion() {
		return metaDataVersion;
	}

	public void setMetaDataVersion(final MetaDataVersion metaDataVersion) {
		this.metaDataVersion = metaDataVersion;
	}

	public boolean isRepeating() {
		return repeating;
	}

	public void setRepeating(final boolean repeating) {
		this.repeating = repeating;
	}

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

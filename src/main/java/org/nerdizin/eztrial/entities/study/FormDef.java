package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidNameEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "def_forms")
public class FormDef extends OidNameEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mdv_id")
	private MetaDataVersion metaDataVersion;

	@Column(name = "repeating")
	private boolean repeating;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "formDef")
	private List<ItemGroupRef> itemGroupRefs;


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

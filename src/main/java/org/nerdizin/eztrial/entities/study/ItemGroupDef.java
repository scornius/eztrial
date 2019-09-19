package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidNameEntity;

import javax.persistence.*;

@Entity
@Table(name = "def_item_groups")
public class ItemGroupDef extends OidNameEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mdv_id")
	private MetaDataVersion metaDataVersion;

	@Column(name = "repeating")
	private boolean repeating;


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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

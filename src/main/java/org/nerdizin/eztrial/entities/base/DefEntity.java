package org.nerdizin.eztrial.entities.base;

import org.nerdizin.eztrial.entities.study.MetaDataVersion;

import javax.persistence.*;

@MappedSuperclass
public abstract class DefEntity extends OidNameEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "mdv_id")
	private MetaDataVersion metaDataVersion;

	@Column(name = "description")
	private String description;


	public MetaDataVersion getMetaDataVersion() {
		return metaDataVersion;
	}

	public void setMetaDataVersion(final MetaDataVersion metaDataVersion) {
		this.metaDataVersion = metaDataVersion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}

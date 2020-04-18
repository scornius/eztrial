package org.nerdizin.eztrial.entities.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Map;

@MappedSuperclass
public abstract class DefEntity extends OidNameEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "mdv_id")
	private MetaDataVersion metaDataVersion;


	public abstract Map<String,String> getDescriptions();

	public abstract void setDescriptions(final Map<String,String> descriptions);

	public abstract void addDescription(final String language, final String text);

	public MetaDataVersion getMetaDataVersion() {
		return metaDataVersion;
	}

	public void setMetaDataVersion(final MetaDataVersion metaDataVersion) {
		this.metaDataVersion = metaDataVersion;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

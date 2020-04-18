package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.nerdizin.eztrial.entities.study.def.Study;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "admin_metadata_version_ref")
public class MetaDataVersionRef extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "study_id")
	private Study study;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "mdv_id")
	private MetaDataVersion metaDataVersion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "location_id")
	private Location location;

	@Column(name = "effective_date", nullable = false)
	private LocalDate effectiveDate;

	public Study getStudy() {
		return study;
	}

	public void setStudy(final Study study) {
		this.study = study;
	}

	public MetaDataVersion getMetaDataVersion() {
		return metaDataVersion;
	}

	public void setMetaDataVersion(final MetaDataVersion metaDataVersion) {
		this.metaDataVersion = metaDataVersion;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(final Location location) {
		this.location = location;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(final LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

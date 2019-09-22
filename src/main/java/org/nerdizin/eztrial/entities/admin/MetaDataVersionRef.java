package org.nerdizin.eztrial.entities.admin;

import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.nerdizin.eztrial.entities.study.Study;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "admin_metadata_version_ref")
public class MetaDataVersionRef extends BaseEntity {

	@OneToOne(optional = false)
	private Study study;

	@OneToOne(optional = false)
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
}

package org.nerdizin.eztrial.entities.admin;

import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.nerdizin.eztrial.entities.study.Study;
import org.nerdizin.eztrial.xml.adapter.LocalDateAdapter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "metadata_version_ref")
public class MetaDataVersionRef extends BaseEntity {

	@OneToOne
	private Study study;

	@OneToOne
	private MetaDataVersion metaDataVersion;

	@Column(name = "effective_date")
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

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(final LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}

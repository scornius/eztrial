package org.nerdizin.eztrial.xml.odm.admin;

import org.joda.time.LocalDate;
import org.nerdizin.eztrial.xml.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class MetaDataVersionRef {

	@XmlAttribute(name = "StudyOID")
	private String studyOid;

	@XmlAttribute(name = "MetaDataVersionOID")
	private String metaDataVersionOid;

	@XmlAttribute(name = "EffectiveDate")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate effectiveDate;


	public String getStudyOid() {
		return studyOid;
	}

	public void setStudyOid(final String studyOid) {
		this.studyOid = studyOid;
	}

	public String getMetaDataVersionOid() {
		return metaDataVersionOid;
	}

	public void setMetaDataVersionOid(final String metaDataVersionOid) {
		this.metaDataVersionOid = metaDataVersionOid;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(final LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}

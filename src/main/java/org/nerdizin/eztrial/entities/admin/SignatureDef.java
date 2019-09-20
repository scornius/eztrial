package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin_signatures")
public class SignatureDef extends BaseEntity {

	@Column(name = "oid", nullable = false, updatable = false, unique = true)
	private String oid;

	@Column(name = "meaning")
	private String meaning;

	@Column(name = "legal_reason")
	private String legalReason;


	public SignatureDef(final String oid) {
		this.oid = oid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(final String oid) {
		this.oid = oid;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(final String meaning) {
		this.meaning = meaning;
	}

	public String getLegalReason() {
		return legalReason;
	}

	public void setLegalReason(final String legalReason) {
		this.legalReason = legalReason;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

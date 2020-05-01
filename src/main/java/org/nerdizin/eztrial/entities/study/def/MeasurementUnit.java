package org.nerdizin.eztrial.entities.study.def;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidNameEntity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "def_measurement_units")
public class MeasurementUnit extends OidNameEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "study_id")
	private Study study;

	@ElementCollection
	@MapKeyColumn(name = "language", unique = true)
	@Column(name = "text")
	@CollectionTable(name="def_munit_translations", joinColumns=@JoinColumn(name="id"))
	private Map<String,String> translations;


	public void addTranslation(final String language, final String text) {
		if (translations == null) {
			translations = new HashMap<>();
		}
		this.translations.put(language, text);
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(final Study study) {
		this.study = study;
	}

	public Map<String,String> getTranslations() {
		return translations;
	}

	public void setTranslations(final Map<String,String> translations) {
		this.translations = translations;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

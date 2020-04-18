package org.nerdizin.eztrial.entities.study.def;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "def_protocol")
public class Protocol extends BaseEntity {

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "mdv_id")
	private MetaDataVersion metaDataVersion;

	@ElementCollection
	@MapKeyColumn(name = "language", unique = true)
	@Column(name = "text")
	@CollectionTable(name="def_protocol_translations", joinColumns=@JoinColumn(name="id"))
	private Map<String,String> translations;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "protocol")
	private List<EventRef> eventRefs;

	public void addTranslation(final String language, final String text) {
		if (translations == null) {
			translations = new HashMap<>();
		}
		this.translations.put(language, text);
	}

	public void addEventRef(final EventRef eventRef) {
		if (this.eventRefs == null) {
			this.eventRefs = new ArrayList<>();
		}
		this.eventRefs.add(eventRef);
	}

	public MetaDataVersion getMetaDataVersion() {
		return metaDataVersion;
	}

	public void setMetaDataVersion(final MetaDataVersion metaDataVersion) {
		this.metaDataVersion = metaDataVersion;
	}

	public Map<String,String> getTranslations() {
		return translations;
	}

	public void setTranslations(final Map<String,String> translations) {
		this.translations = translations;
	}

	public List<EventRef> getEventRefs() {
		return eventRefs;
	}

	public void setEventRefs(final List<EventRef> eventRefs) {
		this.eventRefs = eventRefs;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

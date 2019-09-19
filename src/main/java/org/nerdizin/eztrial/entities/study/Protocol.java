package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "def_protocol")
public class Protocol extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mdv_id")
	private MetaDataVersion metaDataVersion;

	@Column(name = "description")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "protocol")
	private List<EventRef> eventRefs;


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

	public List<EventRef> getEventRefs() {
		return eventRefs;
	}

	public void setEventRefs(final List<EventRef> eventRefs) {
		this.eventRefs = eventRefs;
	}

	public void addEventRef(final EventRef eventRef) {
		if (this.eventRefs == null) {
			this.eventRefs = new ArrayList<>();
		}
		this.eventRefs.add(eventRef);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

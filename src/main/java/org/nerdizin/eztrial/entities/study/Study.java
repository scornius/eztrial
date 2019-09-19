package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "def_studies")
public class Study extends OidEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "protocol_name")
	private String protocolName;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "study")
	private List<MeasurementUnit> measurementUnits;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "study")
	private List<MetaDataVersion> metaDataVersions;


	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(final String protocolName) {
		this.protocolName = protocolName;
	}

	public List<MeasurementUnit> getMeasurementUnits() {
		return measurementUnits;
	}

	public void setMeasurementUnits(final List<MeasurementUnit> measurementUnits) {
		this.measurementUnits = measurementUnits;
	}

	public void addMeasurementUnit(final MeasurementUnit measurementUnit) {
		if (this.measurementUnits == null) {
			this.measurementUnits = new ArrayList<>();
		}
		measurementUnits.add(measurementUnit);
	}

	public List<MetaDataVersion> getMetaDataVersions() {
		return metaDataVersions;
	}

	public void setMetaDataVersions(final List<MetaDataVersion> metaDataVersions) {
		this.metaDataVersions = metaDataVersions;
	}

	public void addMetaDataVersion(final MetaDataVersion metaDataVersion) {
		if (this.metaDataVersions == null) {
			this.metaDataVersions = new ArrayList<>();
		}
		this.metaDataVersions.add(metaDataVersion);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

package org.nerdizin.eztrial.web.rest.converter;

import org.nerdizin.eztrial.entities.study.MetaDataVersion;

public class MetaDataVersionConverter implements Entity2UiModelConverter<MetaDataVersion,org.nerdizin.eztrial.web.rest.model.MetaDataVersion> {

	@Override
	public org.nerdizin.eztrial.web.rest.model.MetaDataVersion convertToUiModel(final MetaDataVersion metaDataVersion) {

		final org.nerdizin.eztrial.web.rest.model.MetaDataVersion result = new
				org.nerdizin.eztrial.web.rest.model.MetaDataVersion();
		result.setName(metaDataVersion.getName());
		result.setOid(metaDataVersion.getOid());

		return result;
	}

	@Override
	public MetaDataVersion convertToEntity(final org.nerdizin.eztrial.web.rest.model.MetaDataVersion metaDataVersion) {

		final MetaDataVersion result = new MetaDataVersion();
		result.setOid(metaDataVersion.getOid());
		result.setName(metaDataVersion.getName());

		return result;
	}
}

package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.MetaDataVersion;

public class MetaDataVersionConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.MetaDataVersion,MetaDataVersion> {

	@Override
	public MetaDataVersion convertToEntity(final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersion) {

		final MetaDataVersion result = new MetaDataVersion();
		result.setOid(metaDataVersion.getOid());
		result.setName(metaDataVersion.getName());

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.MetaDataVersion convertToElement(final MetaDataVersion metaDataVersion) {

		final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion result =
				new org.nerdizin.eztrial.xml.odm.study.MetaDataVersion();
		result.setOid(metaDataVersion.getOid());
		result.setName(metaDataVersion.getName());

		return result;
	}
}

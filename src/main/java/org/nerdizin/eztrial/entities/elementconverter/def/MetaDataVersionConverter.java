package org.nerdizin.eztrial.entities.elementconverter.def;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;

public class MetaDataVersionConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.def.MetaDataVersion,MetaDataVersion> {

	@Override
	public MetaDataVersion convertToEntity(final org.nerdizin.eztrial.xml.odm.study.def.MetaDataVersion metaDataVersion) {

		final MetaDataVersion result = new MetaDataVersion();
		result.setOid(metaDataVersion.getOid());
		result.setName(metaDataVersion.getName());

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.def.MetaDataVersion convertToElement(final MetaDataVersion metaDataVersion) {

		final org.nerdizin.eztrial.xml.odm.study.def.MetaDataVersion result =
				new org.nerdizin.eztrial.xml.odm.study.def.MetaDataVersion();
		result.setOid(metaDataVersion.getOid());
		result.setName(metaDataVersion.getName());

		return result;
	}
}

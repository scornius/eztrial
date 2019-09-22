package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.enums.LocationType;
import org.nerdizin.eztrial.xml.odm.admin.MetaDataVersionRef;

public class LocationConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.admin.Location,Location> {

	@Override
	public Location convert2Entity(final org.nerdizin.eztrial.xml.odm.admin.Location location) {

		final Location result = new Location();
		result.setOid(location.getOid());
		result.setName(location.getName());

		if (location.getLocationType() != null) {
			result.setType(LocationType.fromCode(location.getLocationType().getCode()));
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.Location convert2Element(final Location location) {

		final org.nerdizin.eztrial.xml.odm.admin.Location result =
				new org.nerdizin.eztrial.xml.odm.admin.Location();
		result.setOid(location.getOid());
		result.setName(location.getName());

		if (location.getType() != null) {
			result.setLocationType(org.nerdizin.eztrial.xml.odm.admin.LocationType.fromCode(location.getType().getCode()));
		}

		final Iterable<org.nerdizin.eztrial.entities.admin.MetaDataVersionRef> metaDataVersionRefs = location.getMetaDataVersionRefs();
		if (metaDataVersionRefs != null) {
			for (final org.nerdizin.eztrial.entities.admin.MetaDataVersionRef metaDataVersionRef : metaDataVersionRefs) {
				final org.nerdizin.eztrial.xml.odm.admin.MetaDataVersionRef metaDataVersionRefElement =
						new org.nerdizin.eztrial.xml.odm.admin.MetaDataVersionRef();
				metaDataVersionRefElement.setMetaDataVersionOid(metaDataVersionRef.getMetaDataVersion().getOid());
				metaDataVersionRefElement.setStudyOid(metaDataVersionRef.getStudy().getOid());
				metaDataVersionRefElement.setEffectiveDate(metaDataVersionRef.getEffectiveDate());
				result.addMetaDataVersionRef(metaDataVersionRefElement);
			}
		}

		return result;
	}
}

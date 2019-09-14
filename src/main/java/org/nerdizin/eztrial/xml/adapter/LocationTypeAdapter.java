package org.nerdizin.eztrial.xml.adapter;

import org.nerdizin.eztrial.xml.odm.admin.LocationType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocationTypeAdapter extends XmlAdapter<String, LocationType> {

    @Override
    public LocationType unmarshal(final String code) {
        return LocationType.fromCode(code);
    }

    @Override
    public String marshal(final LocationType locationType) {
        return locationType.getCode();
    }
}

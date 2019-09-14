package org.nerdizin.eztrial.xml.adapter;

import org.nerdizin.eztrial.xml.odm.admin.UserType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UserTypeAdapter extends XmlAdapter<String, UserType> {

    @Override
    public UserType unmarshal(final String code) {
        return UserType.fromCode(code);
    }

    @Override
    public String marshal(final UserType userType) {
        return userType.getCode();
    }
}

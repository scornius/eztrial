package org.nerdizin.eztrial.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class YesNoBooleanAdapter extends XmlAdapter<String, Boolean> {

    private static final String YES = "Yes";
    private static final String NO = "No";

    @Override
    public Boolean unmarshal(final String yesOrNo) {
        if (YES.equalsIgnoreCase(yesOrNo)) {
            return true;
        }
        if (NO.equalsIgnoreCase(yesOrNo)) {
            return false;
        }
        throw new IllegalArgumentException(String.format("Expected yes or no, got %s", yesOrNo));
    }

    @Override
    public String marshal(final Boolean value) {
        if (value != null) {
            return value ? YES : NO;
        }
        throw new IllegalArgumentException("Value may not be null !");
    }
}

package org.nerdizin.eztrial.xml.adapter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, DateTime> {

    private DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public DateTime unmarshal(final String input) throws Exception {
        return DateTime.parse(input);
    }

    @Override
    public String marshal(final DateTime dateTime) throws Exception {
        return formatter.print(dateTime);
    }
}

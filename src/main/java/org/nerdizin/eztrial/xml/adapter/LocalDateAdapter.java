package org.nerdizin.eztrial.xml.adapter;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String,LocalDate> {

	private DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

	@Override
	public LocalDate unmarshal(final String input) {
		return LocalDate.parse(input);
	}

	@Override
	public String marshal(final LocalDate localDate) {
		return formatter.print(localDate);
	}
}

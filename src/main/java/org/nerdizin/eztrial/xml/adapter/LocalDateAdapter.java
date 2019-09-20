package org.nerdizin.eztrial.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String,LocalDate> {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public LocalDate unmarshal(final String input) {
		return LocalDate.parse(input);
	}

	@Override
	public String marshal(final LocalDate localDate) {
		return formatter.format(localDate);
	}
}

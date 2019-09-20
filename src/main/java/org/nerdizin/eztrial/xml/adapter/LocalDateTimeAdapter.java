package org.nerdizin.eztrial.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String,LocalDateTime> {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

	@Override
	public LocalDateTime unmarshal(final String input) {
		return LocalDateTime.parse(input);
	}

	@Override
	public String marshal(final LocalDateTime localDateTime) throws Exception {
		return formatter.format(localDateTime);
	}
}

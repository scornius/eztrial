package org.nerdizin.eztrial.xml.adapter;

import org.nerdizin.eztrial.xml.odm.study.EventType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EventTypeAdapter extends XmlAdapter<String,EventType> {

	@Override
	public EventType unmarshal(final String code) {
		return EventType.fromCode(code);
	}

	@Override
	public String marshal(final EventType eventType) {
		return eventType.getCode();
	}
}

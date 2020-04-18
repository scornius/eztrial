package org.nerdizin.eztrial.xml.adapter;

import org.nerdizin.eztrial.xml.odm.study.def.DataType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DataTypeAdapter extends XmlAdapter<String,DataType> {

	@Override
	public DataType unmarshal(final String code) {
		return DataType.fromCode(code);
	}

	@Override
	public String marshal(final DataType dataType) {
		return dataType.getCode();
	}
}

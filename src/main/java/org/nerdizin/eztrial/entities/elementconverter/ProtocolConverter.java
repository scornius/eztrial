package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.Protocol;

public class ProtocolConverter implements
		OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.Protocol,Protocol> {

	@Override
	public Protocol convert2Entity(final org.nerdizin.eztrial.xml.odm.study.Protocol protocol) {

		final Protocol result = new Protocol();

		return result;
	}
}

package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.Protocol;
import org.nerdizin.eztrial.xml.odm.study.StudyEventRef;

public class ProtocolConverter implements
		OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.Protocol,Protocol> {

	@Override
	public Protocol convert2Entity(final org.nerdizin.eztrial.xml.odm.study.Protocol protocol) {

		final Protocol result = new Protocol();

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.Protocol convert2Element(final Protocol protocol) {

		final org.nerdizin.eztrial.xml.odm.study.Protocol result =
				new org.nerdizin.eztrial.xml.odm.study.Protocol();

		if (protocol.getEventRefs() != null) {
			for (final org.nerdizin.eztrial.entities.study.EventRef eventRef : protocol.getEventRefs()) {
				final StudyEventRef resultEventRef = new StudyEventRef();
				resultEventRef.setMandatory(eventRef.isMandatory());
				resultEventRef.setStudyEventOid(eventRef.getEventDef().getOid());
				result.addStudyEventRef(resultEventRef);
			}
		}

		return result;
	}
}

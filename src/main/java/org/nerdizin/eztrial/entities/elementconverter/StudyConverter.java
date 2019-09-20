package org.nerdizin.eztrial.entities.elementconverter;


import org.nerdizin.eztrial.entities.study.Study;
import org.nerdizin.eztrial.xml.odm.study.GlobalVariables;

public class StudyConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.Study,Study> {

	@Override
	public Study convert2Entity(final org.nerdizin.eztrial.xml.odm.study.Study study) {

		final Study result = new Study();
		result.setOid(study.getOid());

		if (study.getGlobalVariables() != null) {
			result.setName(study.getGlobalVariables().getStudyName());
			result.setDescription(study.getGlobalVariables().getStudyDescription());
			result.setProtocolName(study.getGlobalVariables().getProtocolName());
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.Study convert2Element(final Study study) {

		final org.nerdizin.eztrial.xml.odm.study.Study result =
				new org.nerdizin.eztrial.xml.odm.study.Study();
		result.setOid(study.getOid());

		final GlobalVariables globalVariables = new GlobalVariables();
		globalVariables.setStudyName(study.getName());
		globalVariables.setStudyDescription(study.getDescription());
		globalVariables.setProtocolName(study.getProtocolName());
		result.setGlobalVariables(globalVariables);
		
		return result;
	}
}

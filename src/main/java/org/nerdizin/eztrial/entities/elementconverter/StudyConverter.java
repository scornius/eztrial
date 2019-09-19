package org.nerdizin.eztrial.entities.elementconverter;


import org.nerdizin.eztrial.entities.study.Study;

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

}

package org.nerdizin.eztrial.entities.elementconverter.def;


import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.def.Study;
import org.nerdizin.eztrial.xml.odm.study.def.GlobalVariables;

public class StudyConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.def.Study,Study> {

	@Override
	public Study convertToEntity(final org.nerdizin.eztrial.xml.odm.study.def.Study study) {

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
	public org.nerdizin.eztrial.xml.odm.study.def.Study convertToElement(final Study study) {

		final org.nerdizin.eztrial.xml.odm.study.def.Study result =
				new org.nerdizin.eztrial.xml.odm.study.def.Study();
		result.setOid(study.getOid());

		final GlobalVariables globalVariables = new GlobalVariables();
		globalVariables.setStudyName(study.getName());
		globalVariables.setStudyDescription(study.getDescription());
		globalVariables.setProtocolName(study.getProtocolName());
		result.setGlobalVariables(globalVariables);
		
		return result;
	}
}

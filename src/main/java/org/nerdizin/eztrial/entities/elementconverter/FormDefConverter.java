package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.FormDef;

public class FormDefConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.FormDef,FormDef> {

	@Override
	public FormDef convert2Entity(final org.nerdizin.eztrial.xml.odm.study.FormDef formDef) {

		final FormDef result = new FormDef();
		result.setOid(formDef.getOid());
		result.setName(formDef.getName());
		result.setRepeating(formDef.getRepeating());

		return result;
	}
}

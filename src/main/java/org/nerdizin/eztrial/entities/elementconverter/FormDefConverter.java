package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.FormDef;
import org.nerdizin.eztrial.entities.study.ItemGroupRef;

public class FormDefConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.FormDef,FormDef> {

	@Override
	public FormDef convert2Entity(final org.nerdizin.eztrial.xml.odm.study.FormDef formDef) {

		final FormDef result = new FormDef();
		result.setOid(formDef.getOid());
		result.setName(formDef.getName());
		result.setRepeating(formDef.getRepeating());

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.FormDef convert2Element(final FormDef formDef) {

		final org.nerdizin.eztrial.xml.odm.study.FormDef result = new org.nerdizin.eztrial.xml.odm.study.FormDef();
		result.setOid(formDef.getOid());
		result.setName(formDef.getName());
		result.setRepeating(formDef.isRepeating());

		if (formDef.getItemGroupRefs() != null) {
			for (final ItemGroupRef itemGroupRef : formDef.getItemGroupRefs()) {
				final org.nerdizin.eztrial.xml.odm.study.ItemGroupRef resultItemGroupRef =
						new org.nerdizin.eztrial.xml.odm.study.ItemGroupRef();
				resultItemGroupRef.setMandatory(itemGroupRef.isMandatory());
				resultItemGroupRef.setItemGroupOid(itemGroupRef.getItemGroupDef().getOid());
				result.addItemGroupRef(resultItemGroupRef);
			}
		}

		return result;
	}
}

package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.xml.odm.study.FormDef;
import org.nerdizin.eztrial.xml.odm.study.ItemGroupRef;

public class FormDefConverter implements OdmElement2EntityConverter<FormDef,org.nerdizin.eztrial.entities.study.FormDef> {

	@Override
	public org.nerdizin.eztrial.entities.study.FormDef convert2Entity(final FormDef formDef) {

		final org.nerdizin.eztrial.entities.study.FormDef result = new org.nerdizin.eztrial.entities.study.FormDef();
		result.setOid(formDef.getOid());
		result.setName(formDef.getName());
		result.setRepeating(formDef.getRepeating());

		return result;
	}

	@Override
	public FormDef convert2Element(final org.nerdizin.eztrial.entities.study.FormDef formDef) {

		final FormDef result = new FormDef();
		result.setOid(formDef.getOid());
		result.setName(formDef.getName());
		result.setRepeating(formDef.isRepeating());

		if (formDef.getItemGroupRefs() != null) {
			for (final org.nerdizin.eztrial.entities.study.ItemGroupRef itemGroupRef : formDef.getItemGroupRefs()) {
				final ItemGroupRef resultItemGroupRef =
						new ItemGroupRef();
				resultItemGroupRef.setMandatory(itemGroupRef.isMandatory());
				resultItemGroupRef.setItemGroupOid(itemGroupRef.getItemGroupDef().getOid());
				result.addItemGroupRef(resultItemGroupRef);
			}
		}

		return result;
	}
}

package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.FormDef;
import org.nerdizin.eztrial.entities.study.ItemGroupRef;
import org.nerdizin.eztrial.xml.odm.study.FormDefElement;
import org.nerdizin.eztrial.xml.odm.study.ItemGroupRefElement;

public class FormDefConverter implements OdmElement2EntityConverter<FormDefElement,FormDef> {

	@Override
	public FormDef convert2Entity(final FormDefElement formDef) {

		final FormDef result = new FormDef();
		result.setOid(formDef.getOid());
		result.setName(formDef.getName());
		result.setRepeating(formDef.getRepeating());

		return result;
	}

	@Override
	public FormDefElement convert2Element(final FormDef formDef) {

		final FormDefElement result = new FormDefElement();
		result.setOid(formDef.getOid());
		result.setName(formDef.getName());
		result.setRepeating(formDef.isRepeating());

		if (formDef.getItemGroupRefs() != null) {
			for (final ItemGroupRef itemGroupRef : formDef.getItemGroupRefs()) {
				final ItemGroupRefElement resultItemGroupRef =
						new ItemGroupRefElement();
				resultItemGroupRef.setMandatory(itemGroupRef.isMandatory());
				resultItemGroupRef.setItemGroupOid(itemGroupRef.getItemGroupDef().getOid());
				result.addItemGroupRef(resultItemGroupRef);
			}
		}

		return result;
	}
}

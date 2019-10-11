package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.xml.odm.study.FormDef;
import org.nerdizin.eztrial.xml.odm.study.ItemGroupRef;

public class FormDefConverter implements OdmElementToEntityConverter<FormDef,org.nerdizin.eztrial.entities.study.FormDef> {

	@Override
	public org.nerdizin.eztrial.entities.study.FormDef convertToEntity(final FormDef element) {

		final org.nerdizin.eztrial.entities.study.FormDef result = new org.nerdizin.eztrial.entities.study.FormDef();
		result.setOid(element.getOid());
		result.setName(element.getName());
		result.setRepeating(element.getRepeating());
		DescriptionConverterUtil.convertElementDescription(element, result);

		return result;
	}

	@Override
	public FormDef convertToElement(final org.nerdizin.eztrial.entities.study.FormDef entity) {

		final FormDef result = new FormDef();
		result.setOid(entity.getOid());
		result.setName(entity.getName());
		result.setRepeating(entity.isRepeating());
		DescriptionConverterUtil.convertEntityDescription(entity, result);

		if (entity.getItemGroupRefs() != null) {
			for (final org.nerdizin.eztrial.entities.study.ItemGroupRef itemGroupRef : entity.getItemGroupRefs()) {
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

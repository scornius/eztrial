package org.nerdizin.eztrial.entities.elementconverter.def;

import org.nerdizin.eztrial.entities.elementconverter.common.DescriptionConverterUtil;
import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.def.ItemRef;
import org.nerdizin.eztrial.xml.odm.study.def.ItemGroupDef;
import org.nerdizin.eztrial.xml.odm.study.def.ItemRefElement;

public class ItemGroupDefConverter implements OdmElementToEntityConverter<ItemGroupDef, org.nerdizin.eztrial.entities.study.def.ItemGroupDef> {

	@Override
	public org.nerdizin.eztrial.entities.study.def.ItemGroupDef convertToEntity(final ItemGroupDef element) {

		final org.nerdizin.eztrial.entities.study.def.ItemGroupDef result = new org.nerdizin.eztrial.entities.study.def.ItemGroupDef();
		result.setOid(element.getOid());
		result.setName(element.getName());
		result.setRepeating(element.getRepeating());
		DescriptionConverterUtil.convertElementDescription(element, result);

		return result;
	}

	@Override
	public ItemGroupDef convertToElement(final org.nerdizin.eztrial.entities.study.def.ItemGroupDef entity) {

		final ItemGroupDef result = new ItemGroupDef();
		result.setOid(entity.getOid());
		result.setName(entity.getName());
		result.setRepeating(entity.isRepeating());
		DescriptionConverterUtil.convertEntityDescription(entity, result);

		if (entity.getItemRefs() != null) {
			for (final ItemRef itemRef : entity.getItemRefs()) {
				final ItemRefElement resultItemRef =
						new ItemRefElement();
				resultItemRef.setMandatory(itemRef.isMandatory());
				resultItemRef.setItemOid(itemRef.getItemDef().getOid());
				result.addItemRef(resultItemRef);
			}
		}

		return result;
	}
}

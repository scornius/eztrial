package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.ItemRef;
import org.nerdizin.eztrial.xml.odm.study.ItemGroupDef;
import org.nerdizin.eztrial.xml.odm.study.ItemRefElement;

public class ItemGroupDefConverter implements OdmElementToEntityConverter<ItemGroupDef,org.nerdizin.eztrial.entities.study.ItemGroupDef> {

	@Override
	public org.nerdizin.eztrial.entities.study.ItemGroupDef convertToEntity(final ItemGroupDef element) {

		final org.nerdizin.eztrial.entities.study.ItemGroupDef result = new org.nerdizin.eztrial.entities.study.ItemGroupDef();
		result.setOid(element.getOid());
		result.setName(element.getName());
		result.setRepeating(element.getRepeating());
		DescriptionConverterUtil.convertElementDescription(element, result);

		return result;
	}

	@Override
	public ItemGroupDef convertToElement(final org.nerdizin.eztrial.entities.study.ItemGroupDef entity) {

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

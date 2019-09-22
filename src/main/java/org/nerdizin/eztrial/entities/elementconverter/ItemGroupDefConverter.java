package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.ItemRef;
import org.nerdizin.eztrial.xml.odm.study.ItemGroupDef;
import org.nerdizin.eztrial.xml.odm.study.ItemRefElement;

public class ItemGroupDefConverter implements
		OdmElement2EntityConverter<ItemGroupDef,org.nerdizin.eztrial.entities.study.ItemGroupDef> {

	@Override
	public org.nerdizin.eztrial.entities.study.ItemGroupDef convert2Entity(final ItemGroupDef itemGroupDef) {

		final org.nerdizin.eztrial.entities.study.ItemGroupDef result = new org.nerdizin.eztrial.entities.study.ItemGroupDef();
		result.setOid(itemGroupDef.getOid());
		result.setName(itemGroupDef.getName());
		result.setRepeating(itemGroupDef.getRepeating());

		return result;
	}

	@Override
	public ItemGroupDef convert2Element(final org.nerdizin.eztrial.entities.study.ItemGroupDef itemGroupDef) {

		final ItemGroupDef result = new ItemGroupDef();
		result.setOid(itemGroupDef.getOid());
		result.setName(itemGroupDef.getName());
		result.setRepeating(itemGroupDef.isRepeating());

		if (itemGroupDef.getItemRefs() != null) {
			for (final ItemRef itemRef : itemGroupDef.getItemRefs()) {
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

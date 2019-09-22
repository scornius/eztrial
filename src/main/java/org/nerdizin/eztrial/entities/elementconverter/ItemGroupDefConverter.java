package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.ItemGroupDef;
import org.nerdizin.eztrial.entities.study.ItemRef;
import org.nerdizin.eztrial.xml.odm.study.ItemGroupDefElement;
import org.nerdizin.eztrial.xml.odm.study.ItemRefElement;

public class ItemGroupDefConverter implements
		OdmElement2EntityConverter<ItemGroupDefElement,ItemGroupDef> {

	@Override
	public ItemGroupDef convert2Entity(final ItemGroupDefElement itemGroupDef) {

		final ItemGroupDef result = new ItemGroupDef();
		result.setOid(itemGroupDef.getOid());
		result.setName(itemGroupDef.getName());
		result.setRepeating(itemGroupDef.getRepeating());

		return result;
	}

	@Override
	public ItemGroupDefElement convert2Element(final ItemGroupDef itemGroupDef) {

		final ItemGroupDefElement result = new ItemGroupDefElement();
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

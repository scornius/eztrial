package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.ItemGroupDef;
import org.nerdizin.eztrial.entities.study.ItemRef;

public class ItemGroupDefConverter implements
		OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.study.ItemGroupDef,ItemGroupDef> {

	@Override
	public ItemGroupDef convert2Entity(final org.nerdizin.eztrial.xml.odm.study.ItemGroupDef itemGroupDef) {

		final ItemGroupDef result = new ItemGroupDef();
		result.setOid(itemGroupDef.getOid());
		result.setName(itemGroupDef.getName());
		result.setRepeating(itemGroupDef.getRepeating());

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.study.ItemGroupDef convert2Element(final ItemGroupDef itemGroupDef) {

		final org.nerdizin.eztrial.xml.odm.study.ItemGroupDef result = new org.nerdizin.eztrial.xml.odm.study.ItemGroupDef();
		result.setOid(itemGroupDef.getOid());
		result.setName(itemGroupDef.getName());
		result.setRepeating(itemGroupDef.isRepeating());

		if (itemGroupDef.getItemRefs() != null) {
			for (final ItemRef itemRef : itemGroupDef.getItemRefs()) {
				final org.nerdizin.eztrial.xml.odm.study.ItemRef resultItemRef =
						new org.nerdizin.eztrial.xml.odm.study.ItemRef();
				resultItemRef.setMandatory(itemRef.isMandatory());
				resultItemRef.setItemOid(itemRef.getItemDef().getOid());
				result.addItemRef(resultItemRef);
			}
		}

		return result;
	}
}

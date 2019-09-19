package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.study.ItemGroupDef;

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
}

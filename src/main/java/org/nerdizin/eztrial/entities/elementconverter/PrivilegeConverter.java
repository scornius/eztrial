package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.Privilege;

public class PrivilegeConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.admin.Privilege,Privilege> {

	@Override
	public Privilege convertToEntity(final org.nerdizin.eztrial.xml.odm.admin.Privilege privilege) {

		final Privilege result = new Privilege();
		result.setOid(privilege.getOid());
		result.setValue(privilege.getValue());

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.Privilege convertToElement(final Privilege privilege) {

		final org.nerdizin.eztrial.xml.odm.admin.Privilege result =
				new org.nerdizin.eztrial.xml.odm.admin.Privilege();
		result.setOid(privilege.getOid());
		result.setValue(privilege.getValue());

		return result;
	}
}

package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.SignatureDef;

public class SignatureDefConverter implements
		OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.admin.SignatureDef,SignatureDef> {

	@Override
	public SignatureDef convert2Entity(final org.nerdizin.eztrial.xml.odm.admin.SignatureDef signatureDef) {

		final SignatureDef result = new SignatureDef(signatureDef.getOid());
		result.setLegalReason(signatureDef.getLegalReason());
		result.setMeaning(signatureDef.getMeaning());

		return result;
	}
}

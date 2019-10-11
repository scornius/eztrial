package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.SignatureDef;

public class SignatureDefConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.admin.SignatureDef,SignatureDef> {

	@Override
	public SignatureDef convertToEntity(final org.nerdizin.eztrial.xml.odm.admin.SignatureDef signatureDef) {

		final SignatureDef result = new SignatureDef();
		result.setOid(signatureDef.getOid());
		result.setLegalReason(signatureDef.getLegalReason());
		result.setMeaning(signatureDef.getMeaning());

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.SignatureDef convertToElement(final SignatureDef signatureDef) {

		final org.nerdizin.eztrial.xml.odm.admin.SignatureDef result =
				new org.nerdizin.eztrial.xml.odm.admin.SignatureDef();
		result.setOid(signatureDef.getOid());
		result.setLegalReason(signatureDef.getLegalReason());
		result.setMeaning(signatureDef.getMeaning());

		return result;
	}
}

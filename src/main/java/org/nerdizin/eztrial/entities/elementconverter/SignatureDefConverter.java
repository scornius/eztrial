package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.SignatureDef;

public class SignatureDefConverter implements
		OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.admin.SignatureDef,SignatureDef> {

	@Override
	public SignatureDef convert2Entity(final org.nerdizin.eztrial.xml.odm.admin.SignatureDef signatureDef) {

		final SignatureDef result = new SignatureDef();
		result.setOid(signatureDef.getOid());
		result.setLegalReason(signatureDef.getLegalReason());
		result.setMeaning(signatureDef.getMeaning());

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.SignatureDef convert2Element(final SignatureDef signatureDef) {

		final org.nerdizin.eztrial.xml.odm.admin.SignatureDef result =
				new org.nerdizin.eztrial.xml.odm.admin.SignatureDef();
		result.setOid(signatureDef.getOid());
		result.setLegalReason(signatureDef.getLegalReason());
		result.setMeaning(signatureDef.getMeaning());

		return result;
	}
}

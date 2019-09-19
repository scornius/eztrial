package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.xml.odm.Odm;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class JAXBContextFactory {

	private static JAXBContext odmJaxbContext = null;
	private static Schema odmSchema = null;

	public static synchronized JAXBContext getOdmJAXBContext() throws JAXBException {
		if (odmJaxbContext == null) {
			odmJaxbContext = JAXBContext.newInstance(Odm.class);
		}
		return odmJaxbContext;
	}

	public static synchronized Schema getOdmSchema() throws SAXException {
		if (odmSchema == null) {
			final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			odmSchema = schemaFactory.newSchema(JAXBContextFactory.class.getResource("/odm/ODM1-3-2.xsd"));
		}
		return odmSchema;
	}

}

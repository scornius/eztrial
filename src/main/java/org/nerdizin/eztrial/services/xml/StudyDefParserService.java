package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.xml.odm.Odm;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.ValidationEventHandler;
import java.io.InputStream;
import java.io.OutputStream;

public interface StudyDefParserService {

    Odm parse(InputStream is) throws JAXBException, SAXException;

	Odm parse(InputStream is, ValidationEventHandler validationEventHandler)
			throws JAXBException, SAXException;

	void serialize(Odm odm, OutputStream os) throws JAXBException;

}

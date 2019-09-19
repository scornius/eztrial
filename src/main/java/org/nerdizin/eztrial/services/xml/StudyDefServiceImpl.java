package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.xml.odm.Odm;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class StudyDefServiceImpl implements StudyDefService {

    @Override
    public Odm parse(final InputStream is) throws JAXBException, SAXException {
		return unmarshall(is, null);
    }

    @Override
	public Odm parse(final InputStream is, final ValidationEventHandler validationEventHandler)
			throws JAXBException, SAXException {
		return unmarshall(is, validationEventHandler);
	}

	private Odm unmarshall(final InputStream is,
			final ValidationEventHandler validationEventHandler)
			throws JAXBException, SAXException {

		final JAXBContext context = JAXBContextFactory.getOdmJAXBContext();

		final Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setSchema(JAXBContextFactory.getOdmSchema());
		if (validationEventHandler != null) {
			unmarshaller.setEventHandler(validationEventHandler);
		}
		return (Odm) unmarshaller.unmarshal(is);
	}

	@Override
	public void serialize(final Odm odm, final OutputStream os) throws JAXBException {
		final JAXBContext context = JAXBContextFactory.getOdmJAXBContext();
		final Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(odm, os);
	}
}

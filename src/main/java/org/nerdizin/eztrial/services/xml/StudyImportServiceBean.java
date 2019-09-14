package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.xml.odm.Odm;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

@Service
public class StudyImportServiceBean implements StudyImportService {

    @Override
    public Odm parse(final InputStream is) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(Odm.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final Odm odm = (Odm) unmarshaller.unmarshal(is);

        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(odm, System.out);

        return odm;
    }

}

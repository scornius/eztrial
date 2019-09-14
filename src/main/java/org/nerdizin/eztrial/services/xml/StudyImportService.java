package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.xml.odm.Odm;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

public interface StudyImportService {

    Odm parse(InputStream is) throws JAXBException;

}

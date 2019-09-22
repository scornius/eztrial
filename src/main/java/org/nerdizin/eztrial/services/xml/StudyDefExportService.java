package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.Odm;

public interface StudyDefExportService {

	Odm exportStudyDef(String studyOid, FileType fileType);
}

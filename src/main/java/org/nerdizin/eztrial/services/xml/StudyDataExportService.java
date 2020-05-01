package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.study.data.ClinicalData;

public interface StudyDataExportService {
    ClinicalData exportStudyData(String studyOid,
                                 String mdvOid,
                                 FileType fileType);
}

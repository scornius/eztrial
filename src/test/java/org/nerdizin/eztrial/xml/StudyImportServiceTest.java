package org.nerdizin.eztrial.xml;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nerdizin.eztrial.services.xml.StudyImportService;
import org.nerdizin.eztrial.services.xml.StudyImportServiceBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StudyImportServiceTest {

    private static StudyImportService studyImportService;


    @BeforeClass
    public static void init() {
        studyImportService = new StudyImportServiceBean();
    }

    @Test
    public void testImport() throws Exception {
        studyImportService.parse(this.getClass().getResourceAsStream("/odm/study1.xml"));
    }
}

package org.nerdizin.eztrial;

import org.nerdizin.eztrial.services.xml.StudyDefExportService;
import org.nerdizin.eztrial.services.xml.StudyDefImportService;
import org.nerdizin.eztrial.services.xml.StudyDefParserService;
import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;

@SpringBootApplication
public class EztrialApplication {

	public static void main(final String[] args) {
		SpringApplication.run(EztrialApplication.class);
	}

	@Bean
	public CommandLineRunner locationDemo(StudyDefExportService studyDefExportService,
			StudyDefImportService studyDefImportService,
			StudyDefParserService studyDefParserService) {

		return new CommandLineRunner() {

			@Override
			@Transactional
			public void run(final String... args) throws Exception {

				final File file = new File("/Users/scorn/IdeaProjects/eztrial/src/test/resources/odm/study1.xml");
				final Odm odm = studyDefParserService.parse(new FileInputStream(file));
				studyDefImportService.importStudyDef(odm);

				final Odm exportStudyDef = studyDefExportService.exportStudyDef(
						odm.getStudy().getOid(), FileType.SNAPSHOT);
				studyDefParserService.serialize(exportStudyDef, System.out);
			}
		};
	}
}

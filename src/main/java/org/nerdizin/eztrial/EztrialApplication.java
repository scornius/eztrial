package org.nerdizin.eztrial;

import org.nerdizin.eztrial.services.xml.*;
import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${eztrial.sample.odm}")
	private String sampleOdm;

	@Bean
	public CommandLineRunner locationDemo(StudyDefExportService studyDefExportService,
										  StudyDefImportService studyDefImportService,
										  StudyDefParserService studyDefParserService,
										  StudyDataImportService studyDataImportService,
										  StudyDataExportService studyDataExportService) {

		return new CommandLineRunner() {

			@Override
			@Transactional
			public void run(final String... args) throws Exception {

				final File file = new File(sampleOdm);
				final Odm odm = studyDefParserService.parse(new FileInputStream(file));
				studyDefImportService.importStudyDef(odm);
				studyDataImportService.importStudyData(odm);

				final Odm exportStudyDef = studyDefExportService.exportStudyDef(
						odm.getStudy().getOid(), FileType.SNAPSHOT);
				exportStudyDef.setClinicalData(
						studyDataExportService.exportStudyData(odm.getStudy().getOid(),
								"mdv.1",
								FileType.SNAPSHOT)
				);

				studyDefParserService.serialize(exportStudyDef, System.out);
			}
		};
	}
}

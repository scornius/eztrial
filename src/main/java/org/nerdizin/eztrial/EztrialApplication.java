package org.nerdizin.eztrial;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.repositories.LocationRepository;
import org.nerdizin.eztrial.repositories.SignatureDefRepository;
import org.nerdizin.eztrial.repositories.StudyRepository;
import org.nerdizin.eztrial.repositories.UserRepository;
import org.nerdizin.eztrial.services.xml.StudyDefExportService;
import org.nerdizin.eztrial.services.xml.StudyDefImportService;
import org.nerdizin.eztrial.services.xml.StudyDefParserService;
import org.nerdizin.eztrial.util.Constants;
import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;

@SpringBootApplication
public class EztrialApplication {

	private static final Logger LOG = LoggerFactory.getLogger(EztrialApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(EztrialApplication.class);
	}

	@Bean
	public CommandLineRunner locationDemo(UserRepository userRepository,
			StudyDefExportService studyDefExportService,
			StudyDefImportService studyDefImportService,
			StudyDefParserService studyDefParserService) {

		return new CommandLineRunner() {

			@Override
			@Transactional
			public void run(final String... args) throws Exception {

				User admin = new User();
				admin.setOid(Constants.ADMIN_OID);
				admin.setFirstName("admin");
				admin.setLastName("admin");
				admin.setEmail("admin@foo.org");
				userRepository.save(admin);

				final File file = new File("/Users/ralf/dev/ws/eztrial/src/test/resources/odm/study1.xml");
				final Odm odm = studyDefParserService.parse(new FileInputStream(file));
				studyDefImportService.importStudyDef(odm);

				final Odm exportStudyDef = studyDefExportService.exportStudyDef(
						odm.getStudy().getOid(), FileType.SNAPSHOT);
				studyDefParserService.serialize(exportStudyDef, System.out);
			}
		};
	}

	/*
		final Page<Location> page = locationRepository.findAll(
				PageRequest.of(0, 2, Sort.Direction.DESC, "name", "oid"));
		LOG.info("totalElements: " + page.getTotalElements());
		LOG.info("totalPages: " + page.getTotalPages());
		for (Location location : page) {
			LOG.info(location.toString());
		}
	 */
}

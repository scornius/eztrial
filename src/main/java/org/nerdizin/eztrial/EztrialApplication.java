package org.nerdizin.eztrial;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.admin.SignatureDef;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.entities.study.Study;
import org.nerdizin.eztrial.repositories.LocationRepository;
import org.nerdizin.eztrial.repositories.SignatureDefRepository;
import org.nerdizin.eztrial.repositories.StudyRepository;
import org.nerdizin.eztrial.repositories.UserRepository;
import org.nerdizin.eztrial.services.xml.StudyDefPersistenceService;
import org.nerdizin.eztrial.services.xml.StudyDefService;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
	public CommandLineRunner locationDemo(LocationRepository locationRepository,
			UserRepository userRepository,
			SignatureDefRepository signatureDefRepository,
			StudyRepository studyRepository,
			StudyDefPersistenceService studyDefPersistenceService,
			StudyDefService studyDefService) {

		return new CommandLineRunner() {

			@Override
			@Transactional
			public void run(final String... args) throws Exception {

				User admin = new User();
				admin.setUserType(UserType.OTHER);
				admin.setFirstName("admin");
				admin.setLastName("admin");
				admin.setEmail("admin@foo.org");
				userRepository.save(admin);

				final File file = new File("/Users/ralf/dev/ws/eztrial/src/test/resources/odm/study1.xml");
				final Odm odm = studyDefService.parse(new FileInputStream(file));
				studyDefPersistenceService.persistStudyDef(odm);

				LOG.info("locations");
				for (Location location : locationRepository.findAll()) {
					LOG.info(location.toString());
				}
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

package org.nerdizin.eztrial;

import org.nerdizin.eztrial.entities.Location;
import org.nerdizin.eztrial.entities.User;
import org.nerdizin.eztrial.entities.enums.LocationType;
import org.nerdizin.eztrial.repositories.LocationRepository;
import org.nerdizin.eztrial.repositories.UserRepository;
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
import java.util.stream.Stream;

@SpringBootApplication
public class EztrialApplication {

	private static final Logger LOG = LoggerFactory.getLogger(EztrialApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(EztrialApplication.class);
	}


	@Bean
	public CommandLineRunner locationDemo(LocationRepository locationRepository, UserRepository userRepository) {

		return new CommandLineRunner() {

			@Override
			@Transactional
			public void run(final String... args) throws Exception {

				userRepository.save(new User("admin", "admin", "admin"));

				locationRepository.save(new Location("Center.001", "Medizinische Hochschule Hannover", LocationType.SITE));
				locationRepository.save(new Location("Center.002", "Krankenhaus Dresden-Friedrichstadt", LocationType.SITE));
				locationRepository.save(new Location("Center.003", "Universitätsklinikum Leipzig", LocationType.SITE));
				locationRepository.save(new Location("Center.004", "Klinik für Innere Medizin der FSU Jena", LocationType.SITE));
				locationRepository.save(new Location("Center.005", "Praxis Dr. med. C. John", LocationType.SITE));

				LOG.info("findAll():");
				LOG.info("-------------------------------");
				for (Location location : locationRepository.findAll()) {
					LOG.info(location.toString());
				}

				LOG.info("paging():");
				LOG.info("-------------------------------");
				final Page<Location> page = locationRepository.findAll(PageRequest.of(0, 2, Sort.Direction.DESC, "name", "oid"));
				LOG.info("totalElements: " + page.getTotalElements());
				LOG.info("totalPages: " + page.getTotalPages());
				for (Location location : page) {
					LOG.info(location.toString());
				}

				LOG.info("count");
				LOG.info("-------------------------------");

				LOG.info("count SITE: " + locationRepository.countByType(LocationType.SITE));
				LOG.info("count CRO: " + locationRepository.countByType(LocationType.CRO));

				LOG.info("stream");
				LOG.info("-------------------------------");
				try (Stream<Location> s = locationRepository.findTop2ByType(LocationType.SITE)) {
					s.forEach(l -> LOG.info(l.toString()));
				}
			}
		};
	}

	/*
	@Bean
	public CommandLineRunner userDemo(UserRepository userRepository) {
		return (args) -> {
			userRepository.save(new User("Jack", "Bauer", "jack.bauer@gmail.com"));
			userRepository.save(new User("Chloe", "O'Brian"));

			LOG.info("findAll():");
			LOG.info("-------------------------------");
			for (User user : userRepository.findAll()) {
				LOG.info(user.toString());
			}
			LOG.info("");

			for (User user : userRepository.findByEmailAndFirstName("jack.bauer@gmail.com", "Jack")) {
				LOG.info(user.toString());
			}
		};
	}
	 */
}

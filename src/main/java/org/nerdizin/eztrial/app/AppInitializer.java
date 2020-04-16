package org.nerdizin.eztrial.app;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.services.UserService;
import org.nerdizin.eztrial.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppInitializer {

	private final static Logger log = LoggerFactory.getLogger(AppInitializer.class);

	@Bean
	public CommandLineRunner initDatabase(final UserRepository userRepository,
			final UserService userService) {

		return args -> {
			log.info("Initializing database");

			final User admin = new User();
			admin.setOid(Constants.ADMIN_OID);
			admin.setPassword(userService.encryptPassword("admin"));
			admin.setActive(true);
			admin.setUserName("admin");
			admin.setFirstName("admin");
			admin.setLastName("admin");
			admin.setEmail("admin@foo.org");
			userRepository.save(admin);
		};
	}

}

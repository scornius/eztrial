package org.nerdizin.eztrial.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.util.Constants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppInitializer {

	private final static Log log = LogFactory.getLog(AppInitializer.class);

	@Bean
	public CommandLineRunner initDatabase(final UserRepository userRepository) {
		return args -> {
			log.info("Initializing database");

			final User admin = new User();
			admin.setOid(Constants.ADMIN_OID);
			admin.setUserName("admin");
			admin.setFirstName("admin");
			admin.setLastName("admin");
			admin.setEmail("admin@foo.org");
			userRepository.save(admin);
		};
	}

}

package org.nerdizin.eztrial;

import org.nerdizin.eztrial.entities.User;
import org.nerdizin.eztrial.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EztrialApplication {

	private static final Logger LOG = LoggerFactory.getLogger(EztrialApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(EztrialApplication.class);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
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
}

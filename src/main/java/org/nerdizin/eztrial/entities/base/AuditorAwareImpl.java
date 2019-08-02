package org.nerdizin.eztrial.entities.base;

import org.nerdizin.eztrial.entities.User;
import org.nerdizin.eztrial.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<User> {

	private static final Logger LOG = LoggerFactory.getLogger(AuditorAwareImpl.class);

	private UserRepository userRepository;

	@Override
	public Optional<User> getCurrentAuditor() {

		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			final User admin = new User("admin", "admin");
			admin.setId(1L);
			return Optional.of(admin);
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		LOG.info("XXX1: " + username);
		User user = userRepository.findByUserName(username);
		LOG.info("XXX2: " + user);
		return Optional.of(user);
	}

	@Autowired
	public void setUserRepository(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}

package org.nerdizin.eztrial.entities.base;

import org.nerdizin.eztrial.entities.User;
import org.nerdizin.eztrial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<User> {

	private UserRepository userRepository;

	@Override
	public Optional<User> getCurrentAuditor() {

		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			final User admin = new User("admin", "admin");
			admin.setId(1L);
			return Optional.of(admin);
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUserName(username);
		return Optional.of(user);
	}

	@Autowired
	public void setUserRepository(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}

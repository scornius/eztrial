package org.nerdizin.eztrial.entities.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.util.Constants;
import org.nerdizin.eztrial.web.mvc.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<User> {

	private final static Log log = LogFactory.getLog(UserController.class);

	private UserRepository userRepository;

	@Override
	public Optional<User> getCurrentAuditor() {

		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			final User admin = new User();
			admin.setOid(Constants.ADMIN_OID);
			admin.setId(1L);
			return Optional.of(admin);
		}

		final UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Optional.of(principal.getUser());
	}

	@Autowired
	public void setUserRepository(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}

package org.nerdizin.eztrial.services;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.base.UserPrincipal;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final static Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private final UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String userNameOrEmail) throws UsernameNotFoundException {
		log.info(String.format("Login attempt by %s", userNameOrEmail));
		final Optional<User> userOptional = userRepository.findByUserNameOrEmailAndEagerlyFetchRoles(userNameOrEmail);
		if (userOptional.isEmpty()) {
			throw new UsernameNotFoundException(userNameOrEmail);
		}
		return new UserPrincipal(userOptional.get());
	}

}

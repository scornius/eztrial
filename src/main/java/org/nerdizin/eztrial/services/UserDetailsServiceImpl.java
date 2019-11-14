package org.nerdizin.eztrial.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.base.UserPrincipal;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.web.mvc.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsManager, UserDetailsPasswordService {

	private final static Log log = LogFactory.getLog(UserController.class);

	private final UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
		final Optional<User> userOptional = userRepository.findByUserNameAndEagerlyFetchRoles(userName);
		if (userOptional.isEmpty()) {
			throw new UsernameNotFoundException(userName);
		}
		return new UserPrincipal(userOptional.get());
	}

	@Override
	public UserDetails updatePassword(final UserDetails userDetails, final String s) {
		return null;
	}

	@Override
	public void createUser(final UserDetails userDetails) {

	}

	@Override
	public void updateUser(final UserDetails userDetails) {

	}

	@Override
	public void deleteUser(final String s) {

	}

	@Override
	public void changePassword(final String s, final String s1) {

	}

	@Override
	public boolean userExists(final String userName) {
		log.info("userExists: " + userName);
		return true;
	}
}

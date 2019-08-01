package org.nerdizin.eztrial.services;

import org.nerdizin.eztrial.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceBean implements UserService {

	private final UserRepository userRepository;

	public UserServiceBean(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}


}

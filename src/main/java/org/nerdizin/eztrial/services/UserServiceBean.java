package org.nerdizin.eztrial.services;

import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceBean implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceBean(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}


}

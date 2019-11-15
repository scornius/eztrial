package org.nerdizin.eztrial.services;

import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceBean implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceBean(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String encryptPassword(final String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public List<String> getUserTypes() {

		final List<String> result = new ArrayList<>();
		for (final UserType userType : UserType.values()) {
			result.add(userType.getCode());
		}

		return result;
	}

}

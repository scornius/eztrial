package org.nerdizin.eztrial.services.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.repositories.admin.RoleRepository;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.web.model.admin.Role;
import org.nerdizin.eztrial.web.model.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserSecurityServiceBean implements UserSecurityService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;


	@Autowired
	public UserSecurityServiceBean(final UserRepository userRepository,
								   final PasswordEncoder passwordEncoder,
								   final RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
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

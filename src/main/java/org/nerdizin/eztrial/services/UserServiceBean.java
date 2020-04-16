package org.nerdizin.eztrial.services;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.repositories.admin.RoleRepository;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.web.converter.RoleConverter;
import org.nerdizin.eztrial.web.converter.UserConverter;
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
public class UserServiceBean implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	private static final UserConverter userConverter = new UserConverter();
	private static final RoleConverter roleConverter = new RoleConverter();

	@Autowired
	public UserServiceBean(final UserRepository userRepository,
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

	@Override
	public List<org.nerdizin.eztrial.web.model.admin.User> getAllUsers(final Pagination pagination) {

		final Page<User> page = userRepository.findAll(
				getUserSpecification(pagination),
				PageRequest.of(pagination.getPage(),
						pagination.getRows(),
						pagination.getSortDirection(),
						pagination.getSortBy()));
		return page.stream().map(userConverter::convertToUiModel).collect(Collectors.toList());
	}

	private Specification<User> getUserSpecification(final Pagination pagination) {
		return (Specification<User>) (user, criteriaQuery, cb) -> {

			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(cb.isFalse(user.get("deleted")));
			pagination.getFilters().entrySet().stream()
					.filter(entry -> !StringUtils.isEmpty(entry.getValue()))
					.forEach(entry -> predicates.add(
							cb.like(user.get(entry.getKey()), cb.lower(
									cb.literal("%" + entry.getValue() + "%")))
							)
					);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	@Override
	public List<Role> getAllRoles() {
		return StreamSupport.stream(roleRepository.findAllByOrderByOid().spliterator(), false)
			.map(roleConverter::convertToUiModel)
			.collect(Collectors.toList());
	}


}

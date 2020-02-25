package org.nerdizin.eztrial.web.rest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.web.converter.UserConverter;
import org.nerdizin.eztrial.web.model.admin.User;
import org.nerdizin.eztrial.web.model.common.Pagination;
import org.nerdizin.eztrial.web.rest.base.AbstractRestController;
import org.nerdizin.eztrial.web.rest.base.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserRestController extends AbstractRestController {

	private final static Log log = LogFactory.getLog(UserRestController.class);

	private final UserRepository userRepository;
	private static final UserConverter userConverter = new UserConverter();

	@Autowired
	public UserRestController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@GetMapping("/current")
	public Principal getCurrentUser(final Principal user) {

		return user;
	}

	@GetMapping("/users")
	public List<User> getUsers(final Pagination pagination) {

		final Page<org.nerdizin.eztrial.entities.admin.User> page = userRepository.findAll(
				PageRequest.of(pagination.getPage(),
						pagination.getRows(),
						pagination.getSortDirection(),
						"oid", "userName"));

		return page.stream().map(userConverter::convertToUiModel).collect(Collectors.toList());
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable final Long id) {

		return userRepository.findById(id)
				.map(userConverter::convertToUiModel)
				.orElseThrow(() -> new UserNotFoundException(id));
	}

}

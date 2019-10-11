package org.nerdizin.eztrial.web.rest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.app.AppInitializer;
import org.nerdizin.eztrial.repositories.UserRepository;
import org.nerdizin.eztrial.web.rest.base.UserNotFoundException;
import org.nerdizin.eztrial.web.rest.converter.UserConverter;
import org.nerdizin.eztrial.web.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

	private final static Log log = LogFactory.getLog(AppInitializer.class);

	private final UserRepository userRepository;
	private static final UserConverter userConverter = new UserConverter();

	@Autowired
	public UserController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@GetMapping("/users")
	public List<User> getUsers(
			@RequestParam(value = "page", required = false, defaultValue = "0") final int pageIndex,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") final int pageSize) {

		final Page<org.nerdizin.eztrial.entities.admin.User> page = userRepository.findAll(
				PageRequest.of(pageIndex, pageSize, Sort.Direction.DESC, "oid", "userName"));
		log.info("totalElements: " + page.getTotalElements());
		log.info("totalPages: " + page.getTotalPages());

		return page.stream().map(userConverter::convertToUiModel).collect(Collectors.toList());
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable final Long id) {

		return userRepository.findById(id)
				.map(userConverter::convertToUiModel)
				.orElseThrow(() -> new UserNotFoundException(id));
	}

}

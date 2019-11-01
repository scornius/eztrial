package org.nerdizin.eztrial.web.mvc;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.repositories.UserRepository;
import org.nerdizin.eztrial.web.rest.controller.util.PagingParameters;
import org.nerdizin.eztrial.web.rest.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserRepository userRepository;
	private static final UserConverter userConverter = new UserConverter();

	@Autowired
	public UserController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@GetMapping("/listUsers")
	public String listUsers(final Model model) {

		final PagingParameters pagingParameters = new PagingParameters();
		pagingParameters.setPage(0);
		pagingParameters.setSize(100);

		final Page<User> page = userRepository.findAll(
				PageRequest.of(pagingParameters.getPage(),
						pagingParameters.getSize(),
						pagingParameters.getSortDirection(),
						"oid", "userName"));

		model.addAttribute("users",
				page.stream().map(userConverter::convertToUiModel).collect(Collectors.toList()));
		return "users.html";
	}

}

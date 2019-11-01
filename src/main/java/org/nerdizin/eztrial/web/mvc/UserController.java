package org.nerdizin.eztrial.web.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.repositories.UserRepository;
import org.nerdizin.eztrial.web.converter.UserConverter;
import org.nerdizin.eztrial.web.rest.controller.util.PagingParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

	private final static Log log = LogFactory.getLog(UserController.class);

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
		return "/admin/users.html";
	}

	@GetMapping("/{id}/deleteUser")
	public String deleteUser(final Model model,
			@PathVariable final Long id) {

		log.info("deleteUser " + id);

		return "forward:/user/listUsers";
	}

}

package org.nerdizin.eztrial.web.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.services.UserService;
import org.nerdizin.eztrial.web.converter.UserConverter;
import org.nerdizin.eztrial.web.model.PasswordChange;
import org.nerdizin.eztrial.web.rest.controller.util.PagingParameters;
import org.nerdizin.eztrial.web.validator.PasswordChangeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

	private final static Log log = LogFactory.getLog(UserController.class);
	private static final String NONE = "none";

	private final UserRepository userRepository;
	private final UserService userService;

	private static final UserConverter userConverter = new UserConverter();

	@Autowired
	public UserController(final UserRepository userRepository, final UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@GetMapping("/listUsers")
	@PreAuthorize("hasAuthority(T(org.nerdizin.eztrial.security.Privilege).USER_LIST.key)")
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

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority(T(org.nerdizin.eztrial.security.Privilege).USER_EDIT.key)")
	public String showUser(final Model model,
			@PathVariable final Long id) {

		final Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			model.addAttribute("user", userConverter.convertToUiModel(user.get()));
			model.addAttribute("userTypes", userService.getUserTypes());
			model.addAttribute("passwordChange", new PasswordChange());
		} else {
			return "error";
		}

		return "/admin/user.html";
	}

	@PostMapping
	public String updateUser(final Model model,
			@Valid final org.nerdizin.eztrial.web.model.User user,
			final BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			log.info("errors: " + bindingResult.getAllErrors());
			return "/admin/user.html";
		}

		final Optional<User> userOptional = userRepository.findByIdAndEagerlyFetchRoles(user.getId());
		if (userOptional.isPresent()) {
			final User userEntity = userOptional.get();
			userEntity.setActive(user.isActive());
			userEntity.setFirstName(user.getFirstName());
			userEntity.setLastName(user.getLastName());
			userEntity.setPhone(user.getPhone());
			if (NONE.equals(user.getType())) {
				userEntity.setUserType(null);
			} else {
				userEntity.setUserType(UserType.fromCode(user.getType()));
			}
			final User updatedUser = userRepository.save(userEntity);

			model.addAttribute("user", userConverter.convertToUiModel(updatedUser));
			model.addAttribute("userTypes", userService.getUserTypes());
		} else {
			return "error";
		}

		return "redirect:/user/" + user.getId();
	}

	@GetMapping("/{id}/deleteUser")
	public String deleteUser(final Model model,
			@PathVariable final Long id) {

		log.info("deleteUser " + id);

		return "forward:/user/listUsers";
	}

	@PostMapping("/{id}/changePassword")
	public String changePassword(@Valid final PasswordChange passwordChange,
			@PathVariable final Long id,
			final BindingResult bindingResult) {

		log.info("change password " + id);

		new PasswordChangeValidator().validate(passwordChange, bindingResult);
		if (bindingResult.hasErrors()) {
			log.info("errors: " + bindingResult.getAllErrors());
			return "/admin/user.html";
		}

		final Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()) {
			return "error";
		}

		final User user = userOptional.get();
		user.setPassword(userService.encryptPassword(passwordChange.getPassword1()));
		userRepository.save(user);

		return "redirect:/user/" + id;
	}
}

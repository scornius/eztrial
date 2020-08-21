package org.nerdizin.eztrial.web.controller.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.repositories.admin.RoleRepository;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.services.admin.UserSecurityService;
import org.nerdizin.eztrial.util.Constants;
import org.nerdizin.eztrial.util.EzException;
import org.nerdizin.eztrial.web.converter.UserConverter;
import org.nerdizin.eztrial.web.model.admin.PasswordChange;
import org.nerdizin.eztrial.web.model.common.Pagination;
import org.nerdizin.eztrial.web.validator.PaginationValidator;
import org.nerdizin.eztrial.web.validator.PasswordChangeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/user")
public class UserController {

	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	private static final String NONE = "none";

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserSecurityService userSecurityService;

	private static final UserConverter userConverter = new UserConverter();

	@Autowired
	public UserController(final UserRepository userRepository,
						  final RoleRepository roleRepository,
						  final UserSecurityService userSecurityService) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userSecurityService = userSecurityService;
	}

	/*


	@GetMapping("/listUsers")
	@PreAuthorize("hasAuthority(T(org.nerdizin.eztrial.security.Privilege).USER_LIST.key)")
	public String listUsers(final Model model,
			final Pagination pagination,
			final BindingResult bindingResult) {

		new PaginationValidator().validate(pagination, bindingResult);
		if (bindingResult.hasErrors()) {
			log.info("errors: " + bindingResult.getAllErrors());
			return "/admin/user.html";
		}

		log.info(pagination.toString());

		model.addAttribute("users", userSecurityService.getAllUsers(pagination));
		model.addAttribute("pagination", pagination);
		return "/admin/users.html";
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority(T(org.nerdizin.eztrial.security.Privilege).USER_EDIT.key)")
	public String showUser(final Model model,
			@PathVariable final Long id) {

		final Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isEmpty()) {
			throw new EzException(String.format("No user found with id %s.", id));
		} else {
			final org.nerdizin.eztrial.web.model.admin.User user = userConverter.convertToUiModel(userOpt.get());
			model.addAttribute("user", user);
			model.addAttribute("userTypes", userSecurityService.getUserTypes());
			model.addAttribute("availableRoles",
					UserUtils.getRolesNotAssignedToUser(userSecurityService.getAllRoles(), user));
			model.addAttribute("passwordChange", new PasswordChange());
		}

		return "/admin/user.html";
	}
*/
}

package org.nerdizin.eztrial.web.mvc.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.repositories.admin.RoleRepository;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.services.admin.UserService;
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
	private final UserService userService;

	private static final UserConverter userConverter = new UserConverter();

	@Autowired
	public UserController(final UserRepository userRepository,
						  final RoleRepository roleRepository,
						  final UserService userService) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userService = userService;
	}

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

		model.addAttribute("users", userService.getAllUsers(pagination));
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
			model.addAttribute("userTypes", userService.getUserTypes());
			model.addAttribute("availableRoles",
					UserUtils.getRolesNotAssignedToUser(userService.getAllRoles(), user));
			model.addAttribute("passwordChange", new PasswordChange());
		}

		return "/admin/user.html";
	}

	@PostMapping
	@PreAuthorize("hasAuthority(T(org.nerdizin.eztrial.security.Privilege).USER_EDIT.key)")
	public String updateUser(final Model model,
			@Valid final org.nerdizin.eztrial.web.model.admin.User user,
			final BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			log.info("errors: " + bindingResult.getAllErrors());
			return "/admin/user.html";
		}

		final Optional<User> userOpt = userRepository.findByIdAndEagerlyFetchRoles(user.getId());
		if (userOpt.isPresent()) {
			final User userEntity = userOpt.get();
			userEntity.setActive(user.isActive());
			userEntity.setFirstName(user.getFirstName());
			userEntity.setLastName(user.getLastName());
			userEntity.setPhone(user.getPhone());
			if (NONE.equals(user.getType())) {
				userEntity.setType(null);
			} else {
				userEntity.setType(UserType.fromCode(user.getType()));
			}
			final User updatedUser = userRepository.save(userEntity);

			model.addAttribute("user", userConverter.convertToUiModel(updatedUser));
			model.addAttribute("userTypes", userService.getUserTypes());
		} else {
			throw new EzException(String.format("No user with id %s found", user.getId()));
		}

		return "redirect:/user/" + user.getId();
	}

	@GetMapping("/{id}/deleteUser")
	@PreAuthorize("hasAuthority(T(org.nerdizin.eztrial.security.Privilege).USER_DELETE.key)")
	public String deleteUser(final Model model, @PathVariable final Long id) {

		final Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isEmpty()) {
			throw new EzException(String.format("No user with id %s found", id));
		}
		final User user = userOpt.get();
		if (Constants.ADMIN_OID.equals(user.getOid())) {
			throw new EzException("Admin user may not be deleted");
		}

		user.setDeleted(true);
		userRepository.save(user);

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

		final Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isEmpty()) {
			throw new EzException(String.format("No user with id %s found", id));
		}

		final User user = userOpt.get();
		user.setPassword(userService.encryptPassword(passwordChange.getPassword1()));
		userRepository.save(user);

		return "redirect:/user/" + id;
	}
}

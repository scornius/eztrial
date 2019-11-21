package org.nerdizin.eztrial.web.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.base.UserPrincipal;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.services.UserService;
import org.nerdizin.eztrial.web.model.PasswordChange;
import org.nerdizin.eztrial.web.validator.PasswordChangeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/myAccount")
public class MyAccountController {

	private final static Log log = LogFactory.getLog(UserController.class);

	private final UserRepository userRepository;
	private final UserService userService;

	@Autowired
	public MyAccountController(final UserRepository userRepository, final UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@GetMapping
	public String showForm(final Model model, final Authentication authentication) {

		final UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
		model.addAttribute("passwordChange", new PasswordChange());

		return "/myAccount/my-account.html";
	}

	@PostMapping("/changePassword")
	public String changePassword(final Authentication authentication,
			@Valid final PasswordChange passwordChange,
			final BindingResult bindingResult) {

		new PasswordChangeValidator().validate(passwordChange, bindingResult);

		if (bindingResult.hasErrors()) {
			log.info("errors: " + bindingResult.getAllErrors());
			return "/myAccount/my-account.html";
		}

		final UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
		final User user = principal.getUser();
		user.setPassword(userService.encryptPassword(passwordChange.getPassword1()));
		userRepository.save(user);

		return "redirect:/myAccount";
	}
}

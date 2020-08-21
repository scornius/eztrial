package org.nerdizin.eztrial.web.controller.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.base.UserPrincipal;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.services.admin.UserSecurityService;
import org.nerdizin.eztrial.web.model.admin.PasswordChange;
import org.nerdizin.eztrial.web.validator.PasswordChangeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final static Logger log = LoggerFactory.getLogger(UserController.class);

	private final UserRepository userRepository;
	private final UserSecurityService userSecurityService;

	@Autowired
	public MyAccountController(final UserRepository userRepository, final UserSecurityService userSecurityService) {
		this.userRepository = userRepository;
		this.userSecurityService = userSecurityService;
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
		user.setPassword(userSecurityService.encryptPassword(passwordChange.getPassword1()));
		userRepository.save(user);

		return "redirect:/myAccount";
	}
}

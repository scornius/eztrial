package org.nerdizin.eztrial.web.mvc.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.repositories.admin.PasswordResetRepository;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.services.mail.MailService;
import org.nerdizin.eztrial.util.EzException;
import org.nerdizin.eztrial.web.model.admin.PasswordReset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/resetPassword")
public class PasswordResetController {

    private final UserRepository userRepository;
    private final MailService mailService;
    private final PasswordResetRepository passwordResetRepository;

    @Autowired
    public PasswordResetController(final UserRepository userRepository,
                                   final MailService mailService,
                                   final PasswordResetRepository passwordResetRepository) {
        this.userRepository = userRepository;
        this.mailService = mailService;
        this.passwordResetRepository = passwordResetRepository;
    }

    @GetMapping
    public String initiateForm(final Model model) {
        model.addAttribute("passwordReset", new PasswordReset());
        return "/public/reset-password.html";
    }

    @PostMapping("/initiate")
    public String resetPasswordInitiate(final Model model,
                             final PasswordReset passwordReset,
                             final BindingResult bindingResult) {

        final Optional<User> userOpt = userRepository.findByUserNameOrEmail(passwordReset.getUserNameOrEmail());
        if (userOpt.isEmpty()) {
            bindingResult.rejectValue("userNameOrEmail", "user.validation.email.username.not.found");
            return "/public/reset-password.html";
        }

        final UUID accessToken = UUID.randomUUID();
        final org.nerdizin.eztrial.entities.admin.PasswordReset passwordResetEntity
                = new org.nerdizin.eztrial.entities.admin.PasswordReset();
        final User user = userOpt.get();
        passwordResetEntity.setUser(user);
        passwordResetEntity.setCreatedDate(LocalDateTime.now());
        passwordResetEntity.setAccessToken(accessToken.toString());
        passwordResetRepository.save(passwordResetEntity);

        mailService.sendMail("no-reply@example.org",
                user.getEmail(),
                "password reset request",
                "http://localhost:8080/resetPassword/apply/" + accessToken);

        return "/public/reset-password-token-sent.html";
    }

    @GetMapping("/apply/{accessToken}")
    public String resetPasswordApplyAccessToken(@PathVariable final String accessToken) {

        final Optional<org.nerdizin.eztrial.entities.admin.PasswordReset> opt =
                passwordResetRepository.findByAccessTokenAndValid(accessToken);
        if (opt.isEmpty()) {
            throw new EzException("Invalid token: " + accessToken);
        }

        final org.nerdizin.eztrial.entities.admin.PasswordReset passwordReset = opt.get();
        passwordReset.setUsedDate(LocalDateTime.now());
        passwordResetRepository.save(passwordReset);

        return "/public/change-password-form.html";
    }
}

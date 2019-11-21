package org.nerdizin.eztrial.web.validator;

import org.nerdizin.eztrial.web.model.admin.PasswordChange;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PasswordChangeValidator implements Validator {

	@Override
	public boolean supports(final Class<?> aClass) {
		return PasswordChange.class.equals(aClass);
	}

	@Override
	public void validate(final Object o, final Errors errors) {
		final PasswordChange passwordChange = (PasswordChange) o;
		if (!passwordChange.getPassword1().equals(passwordChange.getPassword2())) {
			errors.rejectValue("password1", "user.validation.passwords.dont.match");
		}
	}
}

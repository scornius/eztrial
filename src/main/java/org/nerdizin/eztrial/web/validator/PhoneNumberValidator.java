package org.nerdizin.eztrial.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint,String> {

	@Override
	public boolean isValid(final String phoneNumber, final ConstraintValidatorContext constraintValidatorContext) {
		return phoneNumber.matches("[\\d\\s()-+]+");
	}
}

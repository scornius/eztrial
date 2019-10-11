package org.nerdizin.eztrial.web.rest.base;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(final Long id) {
		super(String.format("Could not find user with id %s", id));
	}

}

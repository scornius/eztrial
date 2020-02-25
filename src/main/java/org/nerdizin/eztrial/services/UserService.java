package org.nerdizin.eztrial.services;

import java.util.List;

public interface UserService {

	String encryptPassword(String password);

	List<String> getUserTypes();
}

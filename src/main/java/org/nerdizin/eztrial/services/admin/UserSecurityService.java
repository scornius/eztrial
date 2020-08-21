package org.nerdizin.eztrial.services.admin;

import java.util.List;

public interface UserSecurityService {

	String encryptPassword(String password);

	List<String> getUserTypes();

}

package org.nerdizin.eztrial.services.admin;

import org.nerdizin.eztrial.web.model.admin.Role;
import org.nerdizin.eztrial.web.model.common.Pagination;

import java.util.List;

public interface UserService {

	String encryptPassword(String password);

	List<String> getUserTypes();

	List<org.nerdizin.eztrial.web.model.admin.User> getAllUsers(Pagination pagination);

	List<Role> getAllRoles();
}

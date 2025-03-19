package com.app.service;

import java.util.List;
import java.util.Optional;

//import com.cdac.entity.User;
import com.app.Pojo.User;

public interface UserService {

	User addUser(User user);
	
	User updateUser(User user);

	User getUserByEmailAndStatus(String emailId, String status);

	Optional<User> getUserByEmailid(String emailId);

	List<User> getUserByRole(String role);
	
	User getUserById(int userId);
	
	User getUserByEmailIdAndRoleAndStatus(String emailId, String role, String status);
	
	List<User> updateAllUser(List<User> users);
	
	List<User> getUserByRoleAndStatus(String role, String status);
}

package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Pojo.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmailId(String email);

	User findByEmailIdAndStatus(String email, String status);

	User findByRoleAndStatusIn(String role, List<String> status);

	List<User> findByRole(String role);

	
	User findByEmailIdAndRoleAndStatus(String emailId, String role, String status);
	
	List<User> findByRoleAndStatus(String role, String status);

}

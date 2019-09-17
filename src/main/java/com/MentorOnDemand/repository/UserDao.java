package com.MentorOnDemand.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	List<User> findByEmail(String username);

	@Query(value = "SELECT user.userId FROM User user WHERE user.email=?1")
	public long findByUserId(String email);

	@Query(value = "SELECT user FROM User user WHERE user.userId=?1")
	public User findByUserId(long id);

	/*
	 * boolean loginUser(User user) throws SQLException;
	 */
	/*
	 * public int registerUser(User user) throws SQLException;
	 * 
	 * public boolean loginUser(User user) throws SQLException;
	 */
}

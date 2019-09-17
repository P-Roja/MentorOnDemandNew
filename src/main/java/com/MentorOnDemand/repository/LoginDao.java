package com.MentorOnDemand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;

public interface LoginDao extends JpaRepository<Login, String> {

	@Query(value = "SELECT login FROM Login login WHERE login.email=?1 AND login.password=?2")
	List<Login> findByRole(String email, String password);

	List<Login> findByRole(String string);

	@Query(value = "SELECT login FROM Login login WHERE login.email=?1")
	Login findByEmail(String email);

}

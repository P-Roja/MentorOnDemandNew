package com.MentorOnDemand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MentorOnDemand.model.Admin;
import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.User;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	List<Admin> findByEmail(String username);
}

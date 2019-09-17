package com.MentorOnDemand.service;

import java.util.List;

import com.MentorOnDemand.model.Admin;
import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.model.User;

public interface AdminService {
	public void insertSkill(Skills skill) ;
public void updateSkill(Skills skill);
	public List<Admin> findByEmail(String username) ;
}

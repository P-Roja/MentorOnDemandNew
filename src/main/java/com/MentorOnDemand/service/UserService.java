package com.MentorOnDemand.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.model.User;

public interface UserService {
	public void registerUser(User user) ;

	public List<User> findByEmail(String username) ;
	public ArrayList<Skills> getSkillList();
}

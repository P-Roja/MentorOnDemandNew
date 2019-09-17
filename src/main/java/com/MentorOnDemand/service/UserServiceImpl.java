package com.MentorOnDemand.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentorOnDemand.repository.SkillsDao;
import com.MentorOnDemand.repository.UserDao;
import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	SkillsDao skillDao;

	@Override
	public List<User> findByEmail(String username) {

		return userDao.findByEmail(username);
	}

	@Override
	public void registerUser(User user) {
		userDao.save(user);
	}

	@Override
	public ArrayList<Skills> getSkillList() {
		return (ArrayList<Skills>) skillDao.findAll();
	}
}

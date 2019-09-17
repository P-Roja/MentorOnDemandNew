package com.MentorOnDemand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentorOnDemand.model.Admin;
import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.repository.AdminDao;
import com.MentorOnDemand.repository.SkillsDao;
@Service
public class AdminServiceImpl implements AdminService {
@Autowired
AdminDao adminDao;
@Autowired
SkillsDao skillsDao;
	@Override
	public List<Admin> findByEmail(String username) {
		
		return adminDao.findByEmail(username);
	}
	@Override
	public void insertSkill(Skills skill) {
		skillsDao.save(skill);
	}
	@Override
	public void updateSkill(Skills skill) {
		skillsDao.save(skill);
		
	}

}

package com.MentorOnDemand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentorOnDemand.repository.MentorDao;
import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;
@Service
public class MentorServiceImpl implements MentorService
{
	@Autowired
	MentorDao mentorDao;
	

	@Override
	public void registerMentor(Mentor mentor) {
	mentorDao.save(mentor);
		
	}

	@Override
	public List<Mentor> findByEmail(String username) {
		
		return mentorDao.findByEmail(username);
	}

	@Override
	public List<Mentor> getMentorList() {		
		return mentorDao.findAll();
	}

}

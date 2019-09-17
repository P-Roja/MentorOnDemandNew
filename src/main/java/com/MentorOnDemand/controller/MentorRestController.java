package com.MentorOnDemand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;
import com.MentorOnDemand.model.User;
import com.MentorOnDemand.repository.LoginDao;
import com.MentorOnDemand.repository.MentorDao;
import com.MentorOnDemand.repository.UserDao;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MentorRestController {
	@Autowired
	MentorDao mentorDao;
	@Autowired
	LoginDao loginDao;
	
	@PostMapping("/mentor/register")
	public Mentor insertMentor(@RequestBody Mentor mentor)
	{
		Mentor insertMentor=mentorDao.save(mentor);
		Login insertLogin=loginDao.save(new Login(mentor));
		return insertMentor;
		
		
	}

}

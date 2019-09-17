package com.MentorOnDemand.service;

import java.util.List;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;
import com.MentorOnDemand.model.User;

public interface MentorService {
	public void registerMentor(Mentor mentor) ;
    public List<Mentor> getMentorList();
	public List<Mentor> findByEmail(String username) ;
}

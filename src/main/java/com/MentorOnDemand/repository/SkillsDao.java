package com.MentorOnDemand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.model.User;

public interface SkillsDao extends JpaRepository<Skills, Integer> {

	@Query(value = "SELECT skill FROM Skills skill WHERE skill.skillId=?1")
	public Skills findBySkillId(long id);

}

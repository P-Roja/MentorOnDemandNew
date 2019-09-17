package com.MentorOnDemand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;
import com.MentorOnDemand.model.User;

public interface MentorDao extends JpaRepository<Mentor, Integer> {
	List<Mentor> findByEmail(String username);

	@Query(value = "SELECT mentor FROM Mentor mentor WHERE mentor.skills=?1 AND mentor.slotTime=?2")
	List<Mentor> findBySkillsAndSlotTime(String skill, String slotTime);

	@Query(value = "SELECT mentor.mentorId FROM Mentor mentor WHERE mentor.email=?1")
	public long findByMentorId(String email);

	@Query(value = "SELECT mentor FROM Mentor mentor WHERE mentor.skills=?1")
	List<Mentor> findBySkills(String skill);

	@Query(value = "SELECT mentor FROM Mentor mentor WHERE mentor.mentorId=?1")
	public Mentor findByMentorId(long id);
}

package com.MentorOnDemand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MentorOnDemand.model.ProposalRequest;
import com.MentorOnDemand.model.User;

public interface ProposeDao extends JpaRepository<ProposalRequest, Long> {

	@Query(value = "SELECT proposal FROM ProposalRequest proposal WHERE proposal.userId=?1 and proposal.mentorId=?2")
	List<ProposalRequest> findByUserIdAndMentorId(long userId, long mentorId);

	@Query(value = "SELECT proposal FROM ProposalRequest proposal WHERE proposal.proposalId=?1")
	public ProposalRequest findByProposalId(long id);

	/*
	 * @Query(value =
	 * "SELECT proposal FROM ProposalRequest proposal WHERE proposal.mentorId=?1")
	 * public List<ProposalRequest> findByMentoId(long id);
	 */

	@Query(value = "SELECT proposal FROM ProposalRequest proposal WHERE proposal.userId=?1")
	public List<ProposalRequest> findByUserId(long id);
}

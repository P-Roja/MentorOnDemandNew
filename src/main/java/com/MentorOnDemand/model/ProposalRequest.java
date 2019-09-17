package com.MentorOnDemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proposal_request")
public class ProposalRequest {
	public ProposalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "proposal_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long proposalId;
	@Column(name = "user_id")
	private long userId;
	@Column(name = "mentor_id")
	private long mentorId;
	/*
	 * @Column(name="technology_id") private long technologyId;
	 */
	@Column(name = "status")
	private String Status;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public long getProposalId() {
		return proposalId;
	}

	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getMentorId() {
		return mentorId;
	}

	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}

	/*
	 * public long getTechnologyId() { return technologyId; }
	 * 
	 * public void setTechnologyId(long technologyId) { this.technologyId =
	 * technologyId; }
	 * 
	 * public String getStatus() { return Status; }
	 * 
	 * public void setStatus(String status) { Status = status; }
	 */
	public ProposalRequest(long proposalId, long userId, long mentorId/* , long technologyId, String status */) {
		super();
		this.proposalId = proposalId;
		this.userId = userId;
		this.mentorId = mentorId;
		/*
		 * this.technologyId = technologyId; Status = status;
		 */
	}

	public ProposalRequest(long userId2, long mentorId2 /* long technologyId2, String status2 */) {
		// TODO Auto-generated constructor stub
		this.userId = userId2;
		this.mentorId = mentorId2;
		/*
		 * this.technologyId = technologyId2; this.Status = status2;
		 */
	}

}

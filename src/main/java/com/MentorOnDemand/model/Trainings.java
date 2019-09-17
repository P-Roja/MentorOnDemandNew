package com.MentorOnDemand.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainings")
public class Trainings {
	public Trainings() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "training_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long trainingId;
	@Column(name = "user_id")
	private long userId;
	@Column(name = "mentor_id")
	private long mentorId;
	@Column(name = "start_time")
	private Date startTime;
	@Column(name = "end_time")
	private Date endTime;

	public long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Trainings [trainingId=" + trainingId + ", userId=" + userId + ", mentorId=" + mentorId + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

	public Trainings(long trainingId, long userId, long mentorId, Date startTime, Date endTime) {
		super();
		this.trainingId = trainingId;
		this.userId = userId;
		this.mentorId = mentorId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

}

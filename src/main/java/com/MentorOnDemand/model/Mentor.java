package com.MentorOnDemand.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mentor")
public class Mentor {

	public Mentor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "mentorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mentorId;
	@Column(name = "username")
	private String userName;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "contact_number")
	private String contactNumber;
	@Column(name = "linkedin_url")
	private String linkedinUrl;
	@Column(name = "trainingCompleted")
	private int trainingCompleted;
	@Column(name = "fromDate")
	private Date fromDate;
	/*
	 * @ManyToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="user_id") private User user;
	 */

	/*
	 * @Column(name = "fromTime") private String fromTime;
	 * 
	 * @Column(name = "toTime") private String toTime;
	 */

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	@Column(name = "skills")
	private String skills;

	@Column(name = "slot_time")
	private String slotTime;

	@Column(name = "year_of_experience")
	private String yearOfExperience;
	@Column(name = "role")
	private String role = "mentor";

	@Column(name = "access")
	private int access = 0;

	public long getMentorId() {
		return mentorId;
	}

	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	public String getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public int getTrainingCompleted() {
		return trainingCompleted;
	}

	public void setTrainingCompleted(int trainingCompleted) {
		this.trainingCompleted = trainingCompleted;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/*
	 * public String getFromTime() { return fromTime; } public void
	 * setFromTime(String fromTime) { this.fromTime = fromTime; } public String
	 * getToTime() { return toTime; } public void setToTime(String toTime) {
	 * this.toTime = toTime; }
	 */

	public Mentor(long mentorId, String userName, String email, String password, String contactNumber,
			String linkedinUrl, Date fromDate, int trainingCompleted, String regCode, String skills, String slotTime,
			String yearOfExperience, String rating, String selfRating, int access, String address) {
		super();
		this.mentorId = mentorId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.linkedinUrl = linkedinUrl;
		this.fromDate = fromDate;
		this.trainingCompleted = trainingCompleted;
		this.skills = skills;
		this.slotTime = slotTime;
		this.yearOfExperience = yearOfExperience;
		this.address = address;
		this.access = access;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public Mentor(String userName2, String email2, String password2, String contactNumber2, String linkedinUrl2,
			Date fromDate2, int trainingCompleted2, String skills2, String slotTime2, String yearOfExperience2,
			int access2, String role, String address2) {

		this.userName = userName2;
		this.email = email2;
		this.password = password2;
		this.contactNumber = contactNumber2;
		this.linkedinUrl = linkedinUrl2;
		this.fromDate = fromDate2;

		this.trainingCompleted = trainingCompleted2;
		this.skills = skills2;
		this.slotTime = slotTime2;
		this.yearOfExperience = yearOfExperience2;
		this.role = role;
		this.address = address2;
		this.access = access2;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Mentor [mentorId=" + mentorId + ", userName=" + userName + ", address=" + address + ", email=" + email
				+ ", password=" + password + ", contactNumber=" + contactNumber + ", linkedinUrl=" + linkedinUrl
				+ ", trainingCompleted=" + trainingCompleted + ", fromDate=" + fromDate + ", skills=" + skills
				+ ", slotTime=" + slotTime + ", yearOfExperience=" + yearOfExperience + ", role=" + role + ", access="
				+ access + "]";
	}

}

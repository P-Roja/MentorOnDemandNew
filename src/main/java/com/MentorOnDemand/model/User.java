package com.MentorOnDemand.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;

	@Column(name = "gender")
	private String gender;
	@Column(name = "email")
	private String email;
	@Column(name = "contact_number")
	private String contactNumber;
	@Column(name = "reg_code")
	private String regcode = "reg_code_123";
	@Column(name = "active_status")
	private String activeStatus="pending";
	@Column(name = "address")
	private String address;
	@Column(name = "role")
	private String role = "user";
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRegcode() {
		return regcode;
	}

	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public void setRole(String role) {
		this.role = role;
	}

	public User(String userName, String password, String gender, String email, String contactNumber,
			String regcode, String activeStatus, String address, String role) {
		super();
		this.userName = userName;
		this.password = password;

		this.gender = gender;
		this.email = email;
		this.contactNumber = contactNumber;
		this.regcode = regcode;
		this.activeStatus = activeStatus;
		this.address = address;
		this.role = role;
		
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ ", email=" + email + ", contactNumber=" + contactNumber + ", regcode=" + regcode + ", activeStatus="
				+ activeStatus+ ", address=" + address + "]";
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return role;
	}

}

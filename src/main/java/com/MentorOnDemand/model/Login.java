package com.MentorOnDemand.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login_credentials")
public class Login {

	@Column(unique = true)
	private String email;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Column
	private String password;

	@Column
	private int access;

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	@Column
	private String role;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Admin admin;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Mentor mentor;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Login() {

	}

	public float getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginCredentials [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

	public Login(String email, String password, String role, int access) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.access = access;
	}

	public Login(Admin admin) {
		this.email = admin.getEmail();
		this.password = admin.getPassword();
		this.role = admin.getRole();
	}

	public Login(Mentor mentor) {
		this.email = mentor.getEmail();
		this.password = mentor.getPassword();
		this.role = mentor.getRole();
		// TODO Auto-generated constructor stub
	}

	public Login(User user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.role = user.getRole();
		// TODO Auto-generated constructor stub
	}

}
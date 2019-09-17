package com.MentorOnDemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skills {

	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	@Column(name = "skill_name")
	private String skillName;
	@Column(name = "base_amount")
	private String baseAmount;

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(String baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Skills(int skillId, String skillName, String baseAmount) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.baseAmount = baseAmount;
	}

	public Skills(String skillName, String baseAmount) {
		super();
		this.skillName = skillName;
		this.baseAmount = baseAmount;
	}

	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skillName=" + skillName + ", baseAmount=" + baseAmount + "]";
	}

}

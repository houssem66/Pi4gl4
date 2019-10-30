package tn.esprit.mission.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="MissionPolicy")
public class MissionPolicy implements Serializable {


	public MissionPolicy(int id) {
		super();
		this.id = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int maxExpenses;
	private int employeeAge;
	private int performance;
	
	private String gender;

	private String place;

	private String jobTitle;
	private int comSkills;

	
	public MissionPolicy() {
		super();
	}



	public MissionPolicy(String name, int maxExpenses, int employeeAge, String gender, String place, String jobTitle,
			int comSkills) {
		super();
		this.name = name;
		this.maxExpenses = maxExpenses;
		this.employeeAge = employeeAge;
		this.gender = gender;
		this.place = place;
		this.jobTitle = jobTitle;
		this.comSkills = comSkills;
	}



	public MissionPolicy(int id, String name, int maxExpenses, int employeeAge, String gender, String place,
			String jobTitle, int comSkills) {
		super();
		this.id = id;
		this.name = name;
		this.maxExpenses = maxExpenses;
		this.employeeAge = employeeAge;
		this.gender = gender;
		this.place = place;
		this.jobTitle = jobTitle;
		this.comSkills = comSkills;
	}



	public MissionPolicy(int maxExpenses, int employeeAge, String gender, String jobTitle, int comSkills) {
		super();
		this.maxExpenses = maxExpenses;
		this.employeeAge = employeeAge;
		this.gender = gender;
		this.jobTitle = jobTitle;
		this.comSkills = comSkills;
	}



	public MissionPolicy(int maxExpenses, int employeeAge, String gender, String place, String jobTitle,
			int comSkills) {
		super();
		this.maxExpenses = maxExpenses;
		this.employeeAge = employeeAge;
		this.gender = gender;
		this.place = place;
		this.jobTitle = jobTitle;
		this.comSkills = comSkills;
	}



	public MissionPolicy(int id, int maxExpenses, int employeeAge, String gender, String place, String jobTitle,
			int comSkills) {
		super();
		this.id = id;
		this.maxExpenses = maxExpenses;
		this.employeeAge = employeeAge;
		this.gender = gender;
		this.place = place;
		this.jobTitle = jobTitle;
		this.comSkills = comSkills;
	}



	public MissionPolicy(int i, String string) {
		this.id=i;
		this.name=string;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxExpenses() {
		return maxExpenses;
	}

	public void setMaxExpenses(int maxExpenses) {
		this.maxExpenses = maxExpenses;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getComSkills() {
		return comSkills;
	}

	public void setComSkills(int comSkills) {
		this.comSkills = comSkills;
	}

	@Override
	public String toString() {
		return "missionPolicy [id=" + id + ", maxExpenses=" + maxExpenses + ", employeeAge=" + employeeAge + ", gender="
				+ gender + ", jobTitle=" + jobTitle + ", comSkills=" + comSkills + "]";
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPerformance() {
		return performance;
	}



	public void setPerformance(int performance) {
		this.performance = performance;
	}

}

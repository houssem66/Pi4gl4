package tn.esprit.mission.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeQuality")
public class EmployeeQuality extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@OneToOne(cascade = CascadeType.ALL)
//	private Employee employee;

	private int employeeAge;
	private String gender;
	private String jobTitle;
	
	public EmployeeQuality() {
		super();
	}

	

	public EmployeeQuality(int id, int employeeAge, String gender, String jobTitle, int comSkills, int performance) {
		super();
		this.id = id;
		this.employeeAge = employeeAge;
		this.gender = gender;
		this.jobTitle = jobTitle;
		this.comSkills = comSkills;
		this.performance = performance;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Employee getEmployee() {
//		return employee;
//	}

//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

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

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}

	private int comSkills;
	private int performance;

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
}

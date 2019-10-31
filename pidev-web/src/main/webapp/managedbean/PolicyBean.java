package tn.esprit.mission.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;

import tn.esprit.mission.entity.Employee;
import tn.esprit.mission.entity.Mission;
import tn.esprit.mission.entity.MissionPolicy;
import tn.esprit.mission.interfaces.IMissionPolicyService;
import tn.esprit.mission.interfaces.IMissionService;
import tn.esprit.mission.service.MissionPolicyService;
import tn.esprit.mission.service.MissionService;

@ManagedBean

@SessionScoped
public class PolicyBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private MissionPolicy missionPolicy;
	


	private List<MissionPolicy> missionPolicys;
	private int idp;


	private String name;
	private int maxExpenses;
	private int employeeAge;	
	private String gender;
	private String place;
	private String jobTitle;
	private int comSkills;
	private int performance;
	@EJB
	IMissionPolicyService p = new MissionPolicyService();

	



	public void addMissionPolicy() {
		
		p.addMissionPolicy(new MissionPolicy(name,maxExpenses, employeeAge, gender, place, jobTitle, comSkills,performance));

	}

	public void DeletePolicyn(MissionPolicy pol) {
		p.removePolicy(pol.getId());
	}



	private Integer PolicyIdToBeUpdated;

	public void displayPolicy(MissionPolicy pol) {

		MissionPolicy policy = p.getMissioPolicynById(pol.getId());

		PolicyIdToBeUpdated = policy.getId();
	    this.setPerformance(policy.getPerformance());
		this.setName(policy.getName());
		this.setComSkills(policy.getComSkills());
		this.setEmployeeAge((policy.getEmployeeAge()));
		this.setJobTitle(policy.getJobTitle());
		this.setMaxExpenses(policy.getMaxExpenses());
		this.setGender(policy.getGender());
		this.setPlace(policy.getPlace());
		
	}

	


	
	

	
	public Integer getPolicyIdToBeUpdated() {
		return PolicyIdToBeUpdated;
	}

	public void setPolicyIdToBeUpdated(Integer policyIdToBeUpdated) {
		PolicyIdToBeUpdated = policyIdToBeUpdated;
	}

	public void updatePolicy() {

		System.out.println("helooooooooooooo" + PolicyIdToBeUpdated);
		p.updatePolicy(
				new MissionPolicy(PolicyIdToBeUpdated,name, maxExpenses, employeeAge, gender, place, jobTitle, comSkills,performance));
	}
	
	public List<MissionPolicy> getMissionPolicys() {
		missionPolicys = p.getAllmissionPolicy();

		return missionPolicys;
	}
	
	
	public void setMissionPolicys(List<MissionPolicy> missionPolicys) {
		this.missionPolicys = missionPolicys;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MissionPolicy getMissionPolicy() {
		return missionPolicy;
	}

	public void setMissionPolicy(MissionPolicy missionPolicy) {
		this.missionPolicy = missionPolicy;
	}








	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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

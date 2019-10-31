package tn.esprit.mission.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;


import tn.esprit.mission.entity.Mission;
import tn.esprit.mission.entity.MissionPolicy;
import tn.esprit.mission.interfaces.IMissionPolicyService;
import tn.esprit.mission.interfaces.IMissionService;
import tn.esprit.mission.service.MissionPolicyService;
import tn.esprit.mission.service.MissionService;

@ManagedBean

@SessionScoped
public class MissionBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idMissionToBeUpdate;
	private int id;
	private MissionPolicy missionPolicy;
	private MissionPolicy missionPolicySelected;
	private String name;
	private String description;
	
	private List<MissionPolicy> AllPolicys;
	private List<Mission> missions;
	private int idm;
	private int IdMissionSelected;

	public IMissionService getM() {
		return m;
	}

	public void setM(IMissionService m) {
		this.m = m;
	}








	@EJB
	IMissionService m = new MissionService();
	
	@EJB
	IMissionPolicyService p = new MissionPolicyService();

	public void addMission() {
		
		m.addMission(new Mission(new MissionPolicy(1,"policy name"), name, description));

	}




	public List<Mission> getMissions() {
		missions = m.getAllMission();
		return missions;
	}



	

	public void displayMission(Mission mis) {
		
		Mission mission = m.getMissionById(mis.getId());
		idMissionToBeUpdate=mission.getId();
		setIdMissionToBeUpdate((mission.getId()));
		this.setMissionPolicy(mis.getMissionPolicy());
		System.out.println("this.setMissionPolicy(mis.getMissionPolicy()); ==="+mis.getMissionPolicy());
		this.setName(mission.getName());
		this.setDescription(mission.getDescription());
		
	}
	
	

	public void DeleteMission(Mission pol) {
		m.removeMissionById(pol.getId());
	}
	
	public List<MissionPolicy> getAllPolicys(){

		   List<MissionPolicy> items = new ArrayList<MissionPolicy>();
		   List<MissionPolicy> categoryList = p.getAllmissionPolicy();
		    for(MissionPolicy category: categoryList){
		       items.add(new MissionPolicy(category.getId()));
		   }
		   return items;
		}
	


	public void updateMission() {
		System.out.println("ekhdem neyyyykk == "+missionPolicySelected);
	m.updateMission(new Mission(idMissionToBeUpdate,new MissionPolicy(1),name,description));
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}



	public void setAllPolicys(List<MissionPolicy> allPolicys) {
		AllPolicys = allPolicys;
	}

	public int getIdm() {
		return idm;
	}

	public void setIdm(int idm) {
		this.idm = idm;
	}

	public int getIdMissionSelected() {
		return IdMissionSelected;
	}

	public void setIdMissionSelected(int idMissionSelected) {
		IdMissionSelected = idMissionSelected;
	}

	public int getIdMissionToBeUpdate() {
		return idMissionToBeUpdate;
	}

	public void setIdMissionToBeUpdate(int idMissionToBeUpdate) {
		this.idMissionToBeUpdate = idMissionToBeUpdate;
	}

	public MissionPolicy getMissionPolicySelected() {
		return missionPolicySelected;
	}

	public void setMissionPolicySelected(MissionPolicy missionPolicySelected) {
		this.missionPolicySelected = missionPolicySelected;
	}

    public MissionPolicy getPolicy(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (MissionPolicy policy : p.getAllmissionPolicy()){
            if (id.equals(policy.getId())){
                return policy;
            }
        }
        return null;
    }
}

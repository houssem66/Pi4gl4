package tn.esprit.mission.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.mission.entity.Mission;

@Remote
public interface IMissionService {

	void addMission(Mission entrmissioneprise);

	void deleteMissionById(int missionId);

	ArrayList<Mission> getAllCustomer();

	Mission getMissionById(int missionId);

	List<Mission> getAllMission();

	

	void updateMission(Mission mis);

	void removeMissionById(int id);

}

package tn.esprit.mission.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.mission.entity.MissionPolicy;

@Remote
public interface IMissionPolicyService {

	int addMissionPolicy(MissionPolicy missionPolicy);

	void deleteMissionPolicyById(int missionPolicyId);

	List<MissionPolicy> getAllmissionPolicy();

	MissionPolicy getMissioPolicynById(int missionPolicyId);

	int getLastId();

	void updatePolicy(MissionPolicy pol);

	void removePolicy(int id);

	List<Integer> getAllIdmissionPolicy();

}

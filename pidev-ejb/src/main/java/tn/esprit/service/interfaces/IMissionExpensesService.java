package tn.esprit.mission.interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import tn.esprit.mission.entity.MissionExpenses;

@Remote
public interface IMissionExpensesService {

	int addMissionExpenses(MissionExpenses missionExpenses);

	ArrayList<MissionExpenses> getAllMissionExpenses();

	void deletemissionExpensesById(int missionExpensesId);

	MissionExpenses getmissionExpensesById(int missionExpensesId);

}

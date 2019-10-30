package tn.esprit.mission.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.mission.entity.EmployeeQuality;
@Remote
public interface IEmployeeQualityService {

	void addEmployeeQuality(EmployeeQuality empQua);

	List<EmployeeQuality> getAllempQua();

}

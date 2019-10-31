package tn.esprit.mission.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import javax.ejb.EJB;

import tn.esprit.mission.entity.Affectation;
import tn.esprit.mission.entity.EmployeeQuality;
import tn.esprit.mission.entity.Mission;

import tn.esprit.mission.interfaces.IAffectationService;
import tn.esprit.mission.interfaces.IEmployeeQualityService;

import tn.esprit.mission.service.AffectationService;
import tn.esprit.mission.service.EmployeeQualityService;

@ManagedBean

@SessionScoped
public class AssignBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	IAffectationService a = new AffectationService();
	@EJB
	IEmployeeQualityService e = new EmployeeQualityService();

	private Mission mission;

	private EmployeeQuality qualifiedEmployees;

	public void AutoAffectation(Mission mission) {

	}

	public String Affectation(Mission mission) {
		List<EmployeeQuality> empQua;
		this.mission = mission;
		empQua = getQualifiedEmployees(mission);
		Affectation aff = new Affectation();

		aff.setEmployee(empQua.get(0));
		aff.setMission(mission);
		a.addAffectation(aff);

		return "affectation";

	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public List<EmployeeQuality> getQualifiedEmployees(Mission mis) {
		List<EmployeeQuality> qe = e.getAllempQua();
		int calc = 0;
		int i = 0;

		while (i < qe.size()) {

			if (!(qe.get(i).getGender().contentEquals(mis.getMissionPolicy().getGender())
					& qe.get(i).getEmployeeAge() >= mis.getMissionPolicy().getEmployeeAge()
					& qe.get(i).getJobTitle().contentEquals(mis.getMissionPolicy().getJobTitle()))) {

				calc = (qe.get(i).getComSkills() + qe.get(i).getPerformance()) / 2;
				System.out.println(calc);
				System.out.println((Math.abs(calc - mis.getMissionPolicy().getPerformance())));
				if (!(Math.abs(calc - (mis.getMissionPolicy().getPerformance())) <= 10))
					System.out.println(
							"-----------------------------------------insertion afectation---------------------------------");
				qe.remove(i);

			}

			i++;

		}
		System.out.println(calc);

		System.out.println(qe);
		return qe;

	}

	public EmployeeQuality getQualifiedEmployees() {
		qualifiedEmployees = getQualifiedEmployees(mission).get(0);
		return qualifiedEmployees;
	}

	public void setQualifiedEmployees(EmployeeQuality qualifiedEmployees) {
		this.qualifiedEmployees = qualifiedEmployees;
	}

}

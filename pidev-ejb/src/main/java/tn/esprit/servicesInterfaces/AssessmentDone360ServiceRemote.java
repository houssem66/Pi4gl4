package servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import entity.Assessment;
import entity.Assessment360;
import entity.AssessmentDone360;
import entity.CriteriaScore;
import entity.Employee;
@Remote
public interface AssessmentDone360ServiceRemote {

	public void ajouterAssessment360D(Assessment a,int coworker);

	public List<AssessmentDone360> getAllAssessments360(int eId);

	public Assessment360 getAssessment360(AssessmentDone360 ad360);

	public List<CriteriaScore> getCritScores(int assId);

	public void addScore(int a, AssessmentDone360 activeAd360);
	
	
}

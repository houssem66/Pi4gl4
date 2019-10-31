package servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import entity.Assessment;
import entity.Assessment360;
import entity.Employee;

@Remote
public interface AssessmentServiceRemote {

	public void ajouterAssessment(Assessment a);

	public List<Assessment> getAllAssessments();

	public void deleteAssessmentById(int assessmentId);

	public Employee employeeToEvaluate(Assessment360 a360);

	public void checkIfcomplete(int assessmentId);
}

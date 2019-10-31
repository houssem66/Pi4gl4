package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Assessment;
import entity.Assessment360;
import entity.AssessmentDone360;
import entity.Employee;
import servicesInterfaces.AssessmentServiceRemote;


@Stateless
@LocalBean
public class AssessmentService implements AssessmentServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	private EntityManager em;
	
	private Employee e;
	private List<Assessment> as;
	
	
	@Override
	public void ajouterAssessment(Assessment a) {
		
		Assessment360 a360= new Assessment360();
		a360.setFinalized360(false);
		a360.setAssessment(a);
		System.out.println(a360.getId360());
		em.persist(a360);
		a.setAssessment360(a360);
		em.persist(a);
		
	}
	@Override
	public List<Assessment> getAllAssessments() {
		List<Assessment> as = em.createQuery("Select a from Assessment a",
				Assessment.class).getResultList();
				return as;
	}
	@Override
	public void deleteAssessmentById(int assessmentId) {
		em.remove(em.find(Assessment.class, assessmentId));
	}
	@Override
	public void checkIfcomplete(int assessmentId) {
		Assessment a=em.find(Assessment.class, assessmentId);
		int k=0;
		int o=0;
			for (AssessmentDone360 ad360 : a.getAssessment360().getAssessementsDone360()) {
				if(ad360.getCoWorkerScore()>0) {
					o=o+ad360.getCoWorkerScore();	
				k++;
				}
				
			}
			if(k>1)
			{
				a.getAssessment360().setScore360(o/k);
				a.getAssessment360().setFinalized360(true);
				a.setDone360(true);
				a.setScoreGlobal(o/k);
				em.persist(a);
			}
			
			
			
	}
	
	@Override
	public Employee employeeToEvaluate(Assessment360 a360) {
		as=getAllAssessments();
		int x = a360.getId360();
		int y;
		for (Assessment assessment : as) {
			y= assessment.getAssessment360().getId360();
			if (x==y) {
				e=assessment.getEmployee();
				return e;
			}
		}
		return e;
	}
	
	/*@Override
	public void updateAssessment(Assessment assessment) {
		Assessment assess = em.find(Assessment.class, assessment.getIdCriteria());
		assess.setName(assessment.getName());
		assess.setDescription(criteria.getDescription());
		em.persist(crtr);
		
	}*/
}

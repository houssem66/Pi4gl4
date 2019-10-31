package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Assessment;
import entity.Assessment360;
import entity.AssessmentDone360;
import entity.Criteria;
import entity.CriteriaScore;
import entity.Employee;
import services.EmployeeService;
import servicesInterfaces.AssessmentDone360ServiceRemote;

@Stateless
@LocalBean
public class AssessmentDone360Service implements AssessmentDone360ServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	private EntityManager em;

	
	@Override
	public void ajouterAssessment360D(Assessment a,int coworker) {
		EmployeeService employeeService=new EmployeeService();
		Employee e = new Employee();
		e.setIdEmployee(coworker);
			AssessmentDone360 ad360= new AssessmentDone360();
			ad360.setAssessment360(a.getAssessment360());
			ad360.setCoWorker(e);
			em.persist(ad360);
			ajouterCriteriaScore(ad360);
	}
	
	
	public void ajouterCriteriaScore(AssessmentDone360 a360) {
		for (int i = 1; i < 13; i++) {
			Criteria c = new Criteria();
			c.setIdCriteria(i);
			CriteriaScore cs = new CriteriaScore(a360,c);
			em.persist(cs);
		}
	}
	@Override
	public List<AssessmentDone360> getAllAssessments360(int eId) {
		List<AssessmentDone360> asFinal= new ArrayList<AssessmentDone360>();
		List<AssessmentDone360> as = em.createQuery("Select a from AssessmentDone360 a",
				AssessmentDone360.class).getResultList();
		Employee etemp;
		for (AssessmentDone360 assessmentDone360 : as) {
			etemp=assessmentDone360.getCoWorker();
			int a = etemp.getIdEmployee(); 
			boolean b= getAssessment360(assessmentDone360).isFinalized360();
			System.out.println("Coworkers that have assessments to complete :  "+etemp);
			if((a==eId)&&(!b)) {
				
				asFinal.add(assessmentDone360);
			}
		}
				return asFinal;
	}
	@Override
	public Assessment360 getAssessment360(AssessmentDone360 ad360) {
		Assessment360 a360;
		int id360 = ad360.getAssessment360().getId360();
		a360=em.find(Assessment360.class, id360 );
		return a360;
			
	}
	
	@Override
	public List<CriteriaScore> getCritScores(int assId) {
		List<CriteriaScore> asFinal= new ArrayList<CriteriaScore>();
		List<CriteriaScore> as = em.createQuery("Select a from CriteriaScore a",
				CriteriaScore.class).getResultList();
		int a;
		for (CriteriaScore critscore : as) {
			a=critscore.getAssessmentDone().getIdDone360();
			if(a==assId) {
				
				asFinal.add(critscore);
			}
		}
				return asFinal;
	}

	@Override
	public void addScore(int a, AssessmentDone360 activeAd360) {
		// TODO Auto-generated method stub
		AssessmentDone360 ad360 = em.find(AssessmentDone360.class, activeAd360.getIdDone360());
		ad360.setCoWorkerScore(a);
		em.persist(ad360);
	}
	
	
	/*
	@Override
	public void deleteAssessmentById(int assessmentId) {
		em.remove(em.find(Assessment.class, assessmentId));
	}
	
	
	/*@Override
	public void updateAssessment(Assessment assessment) {
		Assessment assess = em.find(Assessment.class, assessment.getIdCriteria());
		assess.setName(assessment.getName());
		assess.setDescription(criteria.getDescription());
		em.persist(crtr);
		
	}*/
}

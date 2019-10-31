package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Null;

import entity.Assessment;
import entity.Assessment360;
import entity.AssessmentDone360;
import entity.Criteria;
import entity.CriteriaScore;
import entity.Employee;
import entity.TypeAssessment;
import services.AssessmentDone360Service;
import services.AssessmentService;
import services.EmployeeService;



@ManagedBean(name = "myassessmentBean")
@SessionScoped
public class MyassessmentBean implements Serializable {
	@PersistenceContext(unitName="pidev-ejb")
	private EntityManager em;
	private static final long serialVersionUID = 1L;
	
		
	
	private int idEmpConnected=4;
	private AssessmentDone360 activeAd360;
	private Employee employeeToEvaluate;
	private List<Employee> employees;
	private Employee connectedEmployee;
	private String connectedEmployeeString;
	private boolean done360;
	
	private List<CriteriaScore> criteriaScores;
	private int AssessDoing360;
	private int scoreGlobal=-1;
	private String resultAssesment;
	
	private int critScor1;
	private int critScor2;
	private int critScor3;
	private int critScor4;
	private int critScor5;
	private int critScor6;
	private int critScor7;
	private int critScor8;
	private int critScor9;
	private int critScor10;
	private int critScor11;
	private int critScor12;
	
	@EJB
	AssessmentDone360Service assessment360DService;
	
	@EJB
	AssessmentService assessmentService;

	@EJB
	EmployeeService employeeService;
	
	public Employee getConnectedEmployee() {
		connectedEmployee=employeeService.findEmployee(idEmpConnected);
		return connectedEmployee;
	}

	public void setConnectedEmployee(Employee connectedEmployee) {
		this.connectedEmployee = employeeService.findEmployee(idEmpConnected);;
	}
	
	
	public String getConnectedEmployeeString() {
		
		connectedEmployeeString=employeeService.findEmployee(idEmpConnected).getFirstName()+" "+employeeService.findEmployee(idEmpConnected).getLastName();
		return connectedEmployeeString;
	}

	public void setConnectedEmployeeString() {
		this.connectedEmployeeString = connectedEmployee.getFirstName()+" "+connectedEmployee.getLastName();
	}
	
	
	

	
	
	private List<AssessmentDone360> assessmentsToDo;

	public List<AssessmentDone360> getAssessmentsToDo() {
		assessmentsToDo= assessment360DService.getAllAssessments360(idEmpConnected);
		return assessmentsToDo;
	}

	public void setAssessmentsToDo(List<AssessmentDone360> assessmentsToDo) {
		this.assessmentsToDo = assessmentsToDo;
	}
	

	public List<CriteriaScore> getCriteriaScores() {
		criteriaScores=assessment360DService.getCritScores(activeAd360.getIdDone360());
		return criteriaScores;
	}

	public void setCriteriaScores(List<CriteriaScore> criteriaScores) {
		this.criteriaScores = criteriaScores;
	}


	public String sendEvaluation() {
		int a=critScor1+critScor2+critScor3+critScor4+critScor5+critScor6+critScor7+critScor8+critScor9+critScor10+critScor11+critScor12;
		assessment360DService.addScore(a,activeAd360);
		activeAd360=null;
		return "myassessments?faces-redirect=true";
	}


	
	public String employeeToEvaluate(int idAssessmentDone360) {
		
		//System.out.println("idassessment done recieved from foreach in jsf : "+ idAssessmentDone360);
		AssessmentDone360 ad360=em.find(AssessmentDone360.class,idAssessmentDone360);
		//System.out.println("assessment done fround from id in jsf : "+ ad360.getIdDone360()  );
		Assessment360 a360 = assessment360DService.getAssessment360(ad360);
		assessmentService.checkIfcomplete(a360.getAssessment().getIdAssessment());
		Employee e = assessmentService.employeeToEvaluate(a360);
		return" "+e.getFirstName()+" "+e.getLastName();
	}
	
	public String evaluateEmployee(int idDone){
		activeAd360 = em.find(AssessmentDone360.class,idDone);
		return "assessmentForm?faces-redirect=true";
	}
	
	public Criteria getCriteriaDetails(CriteriaScore CritScore) {
		
		Criteria c;
		c=em.find(Criteria.class, CritScore.getCriteria().getIdCriteria());
		return c;
	}
	
	

	public int getCritScor1() {
		return critScor1;
	}

	public void setCritScor1(int critScor1) {
		this.critScor1 = critScor1;
	}

	public int getCritScor2() {
		return critScor2;
	}

	public void setCritScor2(int critScor2) {
		this.critScor2 = critScor2;
	}

	public int getCritScor3() {
		return critScor3;
	}

	public void setCritScor3(int critScor3) {
		this.critScor3 = critScor3;
	}

	public int getCritScor4() {
		return critScor4;
	}

	public void setCritScor4(int critScor4) {
		this.critScor4 = critScor4;
	}

	public int getCritScor5() {
		return critScor5;
	}

	public void setCritScor5(int critScor5) {
		this.critScor5 = critScor5;
	}

	public int getCritScor6() {
		return critScor6;
	}

	public void setCritScor6(int critScor6) {
		this.critScor6 = critScor6;
	}

	public int getCritScor7() {
		return critScor7;
	}

	public void setCritScor7(int critScor7) {
		this.critScor7 = critScor7;
	}

	public int getCritScor8() {
		return critScor8;
	}

	public void setCritScor8(int critScor8) {
		this.critScor8 = critScor8;
	}

	public int getCritScor9() {
		return critScor9;
	}

	public void setCritScor9(int critScor9) {
		this.critScor9 = critScor9;
	}

	public int getCritScor10() {
		return critScor10;
	}

	public void setCritScor10(int critScor10) {
		this.critScor10 = critScor10;
	}

	public int getCritScor11() {
		return critScor11;
	}

	public void setCritScor11(int critScor11) {
		this.critScor11 = critScor11;
	}

	public int getCritScor12() {
		return critScor12;
	}

	public void setCritScor12(int critScor12) {
		this.critScor12 = critScor12;
	}

	
	
	
	
	
	
	
	
	
	
}

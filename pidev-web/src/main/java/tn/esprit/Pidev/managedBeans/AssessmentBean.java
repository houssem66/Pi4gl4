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
import entity.Criteria;
import entity.Employee;
import entity.TypeAssessment;
import services.AssessmentDone360Service;
import services.AssessmentService;
import services.EmployeeService;


@ManagedBean(name = "assessmentBean")
@SessionScoped
public class AssessmentBean implements Serializable {
	@PersistenceContext(unitName="pidev-ejb")
	private EntityManager em;
	private static final long serialVersionUID = 1L;
	
	private int idAssessment ;
	private Assessment assessmentAdded;
	private Employee employee;
	private List<Employee> employees;
	private int coworker;
	private List<Integer> coworkers= new ArrayList<Integer>();
	private int employeeId;
	private int employeeSent=0;
	private TypeAssessment type;
	private TypeAssessment[] types;
	private boolean doneSent3;
	private boolean doneSelf;
	private boolean done360;
	
	private int scoreGlobal=-1;
	private String resultAssesment;
	
	
	
	@EJB
	EmployeeService employeeService;
	
	
	
	
	
	
	

	public List<Integer> getCoworkers() {
		return coworkers;
	}

	public void setCoworkers(List<Integer> coworkers) {
		this.coworkers = coworkers;
	}

	public boolean isDoneSent3() {
		return doneSent3;
	}

	public void setDoneSent3() {
		doneSent3= (employeeSent<3);
	}

	public int getEmployeeSent() {
		return employeeSent;
	}

	public void setEmployeeSent(int employeeSent) {
		this.employeeSent = employeeSent;
	}

	public int getCoworker() {
		return coworker;
	}

	public void setCoworker(int coworker) {
		this.coworker = coworker;
	}

	public Assessment getAssessmentAdded() {
		return assessmentAdded;
	}

	public void setAssessmentAdded(Assessment assessmentAdded) {
		this.assessmentAdded = assessmentAdded;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employeeService.getAllEmployees();
	}

	public void setTypes() {  types=TypeAssessment.values(); }
	
	public TypeAssessment[] getTypes() { return TypeAssessment.values(); }
	
	public TypeAssessment getType() {
		return type;
	}
	public void setType(TypeAssessment type) {
		this.type = type;
	}
	public int getIdAssessment() {
		return idAssessment;
	}
	public void setIdAssessment(int idAssessment) {
		this.idAssessment = idAssessment;
	}
	public Employee getEmployee() {
		return employee=employeeService.findEmployee(employeeId);
	}
	public void setEmployee(Employee employee) {
		this.employee = employeeService.findEmployee(employeeId);
	}
	
	public boolean isDoneSelf() {
		return doneSelf;
	}
	public void setDoneSelf(boolean doneSelf) {
		this.doneSelf = doneSelf;
	}
	public boolean isDone360() {
		return done360;
	}
	public void setDone360(boolean done360) {
		this.done360 = done360;
	}
	public int getScoreGlobal() {
		return scoreGlobal;
	}
	public void setScoreGlobal(int scoreGlobal) {
		this.scoreGlobal = scoreGlobal;
	}
	public String getResultAssesment() {
		return resultAssesment;
	}
	public void setResultAssesment(String resultAssesment) {
		this.resultAssesment = resultAssesment;
	}
	
	
	
	@EJB
	
	AssessmentService assessmentService;
	
	public String addAssessment() {
		System.out.println("employeeid gotten from addAssesment in bean : "+employeeId);
		Assessment A=new Assessment(employeeService.findEmployee(employeeId),type);
		A.setDone360(false);
		A.setDoneSelf(false);
		assessmentAdded=A;
		System.out.println(A);
		assessmentService.ajouterAssessment(A);
		coworkers.add(employeeId);
		return "coworkers?faces-redirect=true";
	}
	
	public void deleteAssessment(int idA) {
		assessmentService.deleteAssessmentById(idA);
	}
	
	private List<Assessment> assessments;
	
	public void setAssessments(List<Assessment> assessments) {
		this.assessments = assessments;
	}

	public List<Assessment> getAssessments() {
		assessments = assessmentService.getAllAssessments();
		return assessments;
		} 
	@EJB
	
	AssessmentDone360Service assessment360DService;
	
	public String addAssessment360Coworker() {
		if(coworker!=-1)
		{
		coworkers.add(coworker);
		assessment360DService.ajouterAssessment360D(assessmentAdded, coworker);
		coworkers.add(coworker);
		employeeSent++;
		coworker=-1;
		}
		else {
			return "coworkers";
		}
		if (employeeSent>=3)
		{
			coworkers.clear();
			employeeSent=0;
			return "assessment?faces-redirect=true";
		}
		return "coworkers";
	}
	
	public String doneSendingToCoworker() {
		
		if(employeeSent>0) {
			employeeSent=0;
			coworkers.clear();
			//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "assessment?faces-redirect=true";
		}
		return "coworkers";
	}
	
	public boolean sent360(int eId) {
		System.out.println(eId);
		System.out.println(coworkers.contains(eId));
		return !(coworkers.contains(eId)) ;
	}
	
	public void resultAssessment(int idAssessment) {
		
	}
	
	/*
	public String gotoSubmit()
	{
		
		System.out.println(evalsc.getEmployee(empid));
		employeename=evalsc.getEmployee(empid).toString();
		return "SubmitEvaluation";
		
	}
	*/
	
	
	
	

}

package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Assessment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAssessment ;
	
	@ManyToOne
	private Employee employee;
	
	@Enumerated(EnumType.STRING)
	private TypeAssessment type;
	
	private boolean doneSelf;
	private boolean done360;
	
	private int scoreGlobal;
	private String resultAssesment;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="assessment", orphanRemoval=true)
	private Assessment360 assessment360 ;

	

	public Assessment(int idAssessment, TypeAssessment type, boolean doneSelf, boolean done360, int scoreGlobal,
			String resultAssesment) {
		this.idAssessment = idAssessment;
		this.type = type;
		this.doneSelf = doneSelf;
		this.done360 = done360;
		this.scoreGlobal = scoreGlobal;
		this.resultAssesment = resultAssesment;
		
	}

	public Assessment() {
	}

	
	
	public Assessment(TypeAssessment type) {
		this.type = type;
	}

	public Assessment(Employee employee, TypeAssessment type) {
		this.employee = employee;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Assessement [idAssessment=" + idAssessment + ", Type=" + type + ", doneSelf=" + doneSelf + ", done360="
				+ done360 + ", scoreGlobal=" + scoreGlobal + ", resultAssesment=" + resultAssesment +"]";
	}

	public int getIdAssessment() {
		return idAssessment;
	}

	public void setIdAssessment(int idAssessment) {
		this.idAssessment = idAssessment;
	}

	public TypeAssessment getType() {
		return type;
	}

	public void setType(TypeAssessment type) {
		this.type = type;
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
	
	public Assessment360 getAssessment360() {
		return assessment360;
	}

	public void setAssessment360(Assessment360 assessment360) {
		this.assessment360 = assessment360;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}

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
public class AssessmentDone360 implements Serializable  { 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDone360 ;
	
	@ManyToOne
	private Assessment360 assessment360;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "assessmentDone",orphanRemoval=true)
	private Set<CriteriaScore> criteriaScore;
	
	@ManyToOne
	private Employee coWorker; 
	private int coWorkerScore;
	public AssessmentDone360(int idDone360, Assessment360 assessment360, Set<CriteriaScore> criteriaScore,
			Employee coWorker, int coWorkerScore) {
		super();
		this.idDone360 = idDone360;
		this.assessment360 = assessment360;
		this.criteriaScore = criteriaScore;
		this.coWorker = coWorker;
		this.coWorkerScore = coWorkerScore;
	}
	public AssessmentDone360() {
		super();
	}
	@Override
	public String toString() {
		return "AssessmentDone360 [idDone360=" + idDone360 + ", assessment360=" + assessment360 + ", criteriaScore="
				+ criteriaScore + ", coWorker=" + coWorker + ", coWorkerScore=" + coWorkerScore + "]";
	}
	public int getIdDone360() {
		return idDone360;
	}
	public void setIdDone360(int idDone360) {
		this.idDone360 = idDone360;
	}
	public Assessment360 getAssessment360() {
		return assessment360;
	}
	public void setAssessment360(Assessment360 assessment360) {
		this.assessment360 = assessment360;
	}
	public Set<CriteriaScore> getCriteriaScore() {
		return criteriaScore;
	}
	public void setCriteriaScore(Set<CriteriaScore> criteriaScore) {
		this.criteriaScore = criteriaScore;
	}
	public Employee getCoWorker() {
		return coWorker;
	}
	public void setCoWorker(Employee coWorker) {
		this.coWorker = coWorker;
	}
	public int getCoWorkerScore() {
		return coWorkerScore;
	}
	public void setCoWorkerScore(int coWorkerScore) {
		this.coWorkerScore = coWorkerScore;
	}
	
	
	

}

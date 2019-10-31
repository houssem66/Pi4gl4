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
public class Assessment360 implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id360 ;
	
	private int score360 ;
	private boolean finalized360;
	@OneToOne
	private Assessment assessment;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="assessment360", orphanRemoval=true)
	private Set<AssessmentDone360>  assessmentsDone360;
	public Assessment360(int id360, int score360, boolean finalized360) {
		super();
		this.id360 = id360;
		this.score360 = score360;
		this.finalized360 = finalized360;
	}
	public Assessment360() {
		super();
	}
	@Override
	public String toString() {
		return "Assessment360 [id360=" + id360 + ", score360=" + score360 + ", finalized360=" + finalized360
				+ ", AssessementsDone360=" + assessmentsDone360 +"]";
	}
	
	
	public Assessment getAssessment() {
		return assessment;
	}
	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}
	public int getId360() {
		return id360;
	}
	public void setId360(int id360) {
		this.id360 = id360;
	}
	public int getScore360() {
		return score360;
	}
	public void setScore360(int score360) {
		this.score360 = score360;
	}
	public boolean isFinalized360() {
		return finalized360;
	}
	public void setFinalized360(boolean finalized360) {
		this.finalized360 = finalized360;
	}
	public Set<AssessmentDone360> getAssessementsDone360() {
		return assessmentsDone360;
	}
	//might need to change set to add to the SET ************
	public void setAssessementsDone360(Set<AssessmentDone360> assessementsDone360) {
		assessmentsDone360 = assessementsDone360;
	}
	
	
}

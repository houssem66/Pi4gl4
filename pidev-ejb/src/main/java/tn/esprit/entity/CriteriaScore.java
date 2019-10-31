package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CriteriaScore implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCriteraScore ;
	
	@ManyToOne
	private AssessmentDone360 assessmentDone;
	
	@ManyToOne
	private Criteria criteria;
	
	private int score;
	private String comment;
	public CriteriaScore(int idCriteraScore, AssessmentDone360 assessmentDone, Criteria criteria, int score,
			String comment) {
		this.idCriteraScore = idCriteraScore;
		this.assessmentDone = assessmentDone;
		this.criteria = criteria;
		this.score = score;
		this.comment = comment;
	}
	
	
	public CriteriaScore(AssessmentDone360 assessmentDone, Criteria criteria) {
		this.assessmentDone = assessmentDone;
		this.criteria = criteria;
	}


	public CriteriaScore() {
		super();
	}
	@Override
	public String toString() {
		return "CriteriaScore [idCriteraScore=" + idCriteraScore + ", assessmentDone=" + assessmentDone + ", criteria="
				+ criteria + ", score=" + score + ", comment=" + comment + "]";
	}
	public int getIdCriteraScore() {
		return idCriteraScore;
	}
	public void setIdCriteraScore(int idCriteraScore) {
		this.idCriteraScore = idCriteraScore;
	}
	public AssessmentDone360 getAssessmentDone() {
		return assessmentDone;
	}
	public void setAssessmentDone(AssessmentDone360 assessmentDone) {
		this.assessmentDone = assessmentDone;
	}
	public Criteria getCriteria() {
		return criteria;
	}
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}

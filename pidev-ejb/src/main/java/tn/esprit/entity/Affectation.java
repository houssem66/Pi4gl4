package tn.esprit.mission.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity 
@Table(name="Affectation")
public class Affectation implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	
	private int id; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeQuality employee;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Mission mission;
	
	@Temporal (TemporalType.DATE)
	private Date beginDate;
	
	@Temporal (TemporalType.DATE)
	private Date deadLine;

	private boolean finished;
	
	private int satisfaction;
	
	
	
	

	public Affectation() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeQuality employee) {
		this.employee = employee;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public Affectation(EmployeeQuality employee, Mission mission, Date beginDate, Date deadLine, boolean finished,
			int satisfaction) {
		super();
		this.employee = employee;
		this.mission = mission;
		this.beginDate = beginDate;
		this.deadLine = deadLine;
		this.finished = finished;
		this.satisfaction = satisfaction;
	}
	
	
	
	
	

}

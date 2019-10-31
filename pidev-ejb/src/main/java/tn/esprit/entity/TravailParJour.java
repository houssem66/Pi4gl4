package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TravailParJour implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	int id;
	String Jour;
	Double nombreDHeureTravaille;
	@ManyToOne
	Timesheet timesheet;
	@ManyToOne
	Employe employe;
	
	
	
	public TravailParJour(int id, String jour, Double nombreDHeureTravaille, Timesheet timesheet, Employe employe) {
		super();
		this.id = id;
		Jour = jour;
		this.nombreDHeureTravaille = nombreDHeureTravaille;
		this.timesheet = timesheet;
		this.employe = employe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJour() {
		return Jour;
	}
	public void setJour(String jour) {
		Jour = jour;
	}
	public Double getNombreDHeureTravaille() {
		return nombreDHeureTravaille;
	}
	public void setNombreDHeureTravaille(Double nombreDHeureTravaille) {
		this.nombreDHeureTravaille = nombreDHeureTravaille;
	}
	public Timesheet getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}

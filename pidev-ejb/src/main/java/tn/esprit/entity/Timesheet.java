package tn.esprit.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Timesheet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	int id;
	String designation;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="timesheet")
	Set<Tache> taches;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="timesheet")
	Set<TravailParJour> travailParJour;
	
	
	
	public Timesheet(int id, String designation, Set<Tache> taches, Set<TravailParJour> travailParJour) {
		super();
		this.id = id;
		this.designation = designation;
		this.taches = taches;
		this.travailParJour = travailParJour;
	}
	
	public Timesheet() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Set<TravailParJour> getTravailParJour() {
		return travailParJour;
	}
	public void setTravailParJour(Set<TravailParJour> travailParJour) {
		this.travailParJour = travailParJour;
	}
	
	
	

}

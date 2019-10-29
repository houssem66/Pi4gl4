package tn.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class FicheMetier implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Name;
	@OneToOne
	private Employe employe;
	private String description;
	@ManyToOne
	private MatriceComp matricecomp;

	public FicheMetier() {

	}

	// constructeur sans id et matricecomps
	public FicheMetier(String name, Employe employe, String description) {

		Name = name;
		this.employe = employe;
		this.description = description;
		
	}
	public FicheMetier(int id,String name, String description) {

		Name = name;
		this.Id=id;
		this.description = description;
		
	}
	public FicheMetier(String name,  String description) {

		Name = name;
		this.description = description;
		
	}
// constructeur avec id sans matricecomps
	public FicheMetier(int id, String name, Employe employe, String description   ) {
		
		Id = id;
		Name = name;
		this.employe = employe;
		this.description = description;
	}

	public FicheMetier(String name, Employe employe, String description,  MatriceComp matricecomp) {
		
		Name = name;
		this.employe = employe;
		this.description = description;
		this.matricecomp = matricecomp;
	}

	public FicheMetier(int id, String name, Employe employe, String description,   
			MatriceComp matricecomp) {
		
		Id = id;
		Name = name;
		this.employe = employe;
		this.description = description;
		
		this.matricecomp = matricecomp;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MatriceComp getMatricecomp() {
		return matricecomp;
	}

	public void setMatricecomp(MatriceComp matricecomp) {
		this.matricecomp = matricecomp;
	}


	
	

}

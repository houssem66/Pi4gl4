package tn.esprit.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity

public class Employe// extends User 
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String nom;
	private String prenom;
	@Enumerated(EnumType.STRING)
    private Grade grade;
	private String title;
	@OneToOne
	FicheMetier ficheMetier;
	@OneToOne
	MatriceComp matriceComp;
	boolean demande;
	public Employe() {
		
	}

	public Employe(int id, String title) {
	
		Id = id;
		this.title = title;
		
	}

	
	

	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Employe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	int id;
	String nom;
	String prenom;
	@ManyToOne
	Equipe equipe;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employe")
	Set<Tache> taches;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employe")
	Set<BonPoint> bonPoint;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employe")
	Set<TravailParJour> travailParJour;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employe")
	Set<Notification> notifications;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employe")
	Set<Reclammation> reclammations;
	
	
	
	public Employe(int id, String nom, String prenom, Equipe equipe, Set<Tache> taches, Set<BonPoint> bonPoint,
			Set<TravailParJour> travailParJour, Set<Notification> notifications, Set<Reclammation> reclammations) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.equipe = equipe;
		this.taches = taches;
		this.bonPoint = bonPoint;
		this.travailParJour = travailParJour;
		this.notifications = notifications;
		this.reclammations = reclammations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public Set<Tache> getTaches() {
		return taches;
	}
	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}
	public Set<BonPoint> getBonPoint() {
		return bonPoint;
	}
	public void setBonPoint(Set<BonPoint> bonPoint) {
		this.bonPoint = bonPoint;
	}
	public Set<TravailParJour> getTravailParJour() {
		return travailParJour;
	}
	public void setTravailParJour(Set<TravailParJour> travailParJour) {
		this.travailParJour = travailParJour;
	}
	public Set<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
	public Set<Reclammation> getReclammations() {
		return reclammations;
	}
	public void setReclammations(Set<Reclammation> reclammations) {
		this.reclammations = reclammations;
	}
	
	

}

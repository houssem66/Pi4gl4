package tn.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	@Enumerated(EnumType.STRING)
    @NotNull
	private Category category;
	@OneToMany(mappedBy="fiche",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private  List<NiveauxFiche> NiveauxFiche;
	public FicheMetier() {

	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<NiveauxFiche> getNiveauxFiche() {
		return NiveauxFiche;
	}
	public void setNiveauxFiche(List<NiveauxFiche> niveauxFiche) {
		NiveauxFiche = niveauxFiche;
	}
	public FicheMetier(Category category) {
		super();
		this.category = category;
	}
	

}

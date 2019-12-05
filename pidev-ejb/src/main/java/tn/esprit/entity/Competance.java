package tn.esprit.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
@Entity
public class Competance implements Serializable {
	private static final long serialVersionUID = 6191889143079517027L;
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@OneToMany(mappedBy="competance",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private  List<NiveauxFiche> NiveauxFiche;
	@OneToMany(mappedBy="competance",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private  List<NiveauxMat> NiveauxMat;


	public Competance() {
		super();
	}

	public Competance(String name, String description, Type type) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<NiveauxFiche> getNiveauxFiche() {
		return NiveauxFiche;
	}
   // @XmlTransient
	public void setNiveauxFiche(List<NiveauxFiche> niveauxFiche) {
		NiveauxFiche = niveauxFiche;
	}

	public List<NiveauxMat> getNiveauxMat() {
		return NiveauxMat;
	}
//	@XmlTransient
	public void setNiveauxMat(List<NiveauxMat> niveauxMat) {
		NiveauxMat = niveauxMat;
	}

	


}

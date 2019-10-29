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
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import javax.persistence.JoinColumn;
@Entity
public class MatriceComp implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Enumerated(EnumType.STRING)
    @NotNull
	private Category category;
	private String Description;
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "MatriceComp_Comp",
    joinColumns = {@JoinColumn(name = "idMatrice", referencedColumnName = "Id")},
    inverseJoinColumns = { @JoinColumn(name = "idCompetance", referencedColumnName = "Id")}
	)
	private List<Competance> competances;

	public MatriceComp() {

	}

	
	public MatriceComp(int id, Category category, String description) {
		
		Id = id;
		this.category = category;
		Description = description;
	}





	public MatriceComp(Category category, String description) {
	
		this.category = category;
		Description = description;
	}





	public MatriceComp(int id, Category category, String description, List<Competance> competances) {
		
		Id = id;
		this.category = category;
		Description = description;
		this.competances = competances;
	}





	public List<Competance> getCompetances() {
		return competances;
	}

	public void setCompetances(List<Competance> competances) {
		this.competances = competances;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	

	


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + Id;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((competances == null) ? 0 : competances.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriceComp other = (MatriceComp) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Id != other.Id)
			return false;
		if (category != other.category)
			return false;
		if (competances == null) {
			if (other.competances != null)
				return false;
		} else if (!competances.equals(other.competances))
			return false;
		return true;
	}

}

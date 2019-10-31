package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Criteria implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCriteria ;
	
	private String name;
	private String description;
	
	
	
	public Criteria(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public Criteria(int idCriteria, String name, String description) {
		this.idCriteria = idCriteria;
		this.name = name;
		this.description = description;
	}
	public Criteria() {
		super();
	}
	@Override
	public String toString() {
		return "Criteria [idCritera=" + idCriteria + ", name=" + name + ", description=" + description + "]";
	}
	public int getIdCriteria() {
		return idCriteria;
	}
	public void setIdCriteria(int idCritera) {
		this.idCriteria = idCritera;
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
	
	
	

}

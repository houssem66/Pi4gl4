package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Equipe {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	int id;
	@OneToOne(mappedBy="equipe")
	Manager manager;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="equipe")
	Set<Employe> employes;
	
    	
	
	public Equipe(int id, Manager manager, Set<Employe> employes) {
		super();
		this.id = id;
		this.manager = manager;
		this.employes = employes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Set<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}
	
	

}

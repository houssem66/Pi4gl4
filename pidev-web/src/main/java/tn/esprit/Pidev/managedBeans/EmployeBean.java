/*package tn.esprit.Pidev.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.entity.*;
import tn.esprit.service.interfaces.*;
import tn.esprit.service.impl.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "employeBean", eager = true)
@SessionScoped
public class EmployeBean implements Serializable {
	private String title;
	private int id;
	private List<Employe> employes;
	private Integer UseroyeIdToBeUpdated;
	
	@EJB
	EmployeService emps;
	@EJB
	FicheMetierService fchs;

	public void setEmployes(List<Employe> employe) {
		this.employes = employe;
	}

	public List<Employe> getEmployes() {

		employes = emps.getAllEmployes();
		return employes;
	}
	public String redADD() 
    {
  	  return "ajout";
  	  
    }
	public String redModify(Employe employe) 
    {this.setTitle(employe.getTitle());
    
     this.setUseroyeIdToBeUpdated(employe.getId());
  	  return "Modify";}
	
	public String updateFiche()
  	{   
		emps.updateEmploye(new Employe(  UseroyeIdToBeUpdated, title)) ;
  	return "index";
  	}
	public String addFicheMetier () {
		Employe employe=new Employe(id,title);
		emps.addEmploye(employe);;
		return "index";
		}
	public void deletefiche(int id) {
	    emps.removeEmploye(id);}
  	  
  	  
  	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Integer getUseroyeIdToBeUpdated() {
		return UseroyeIdToBeUpdated;
	}

	public void setUseroyeIdToBeUpdated(Integer useroyeIdToBeUpdated) {
		UseroyeIdToBeUpdated = useroyeIdToBeUpdated;
	}

}*/

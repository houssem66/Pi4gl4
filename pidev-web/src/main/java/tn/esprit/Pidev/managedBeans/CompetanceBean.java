package tn.esprit.Pidev.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import tn.esprit.entity.*;
import tn.esprit.service.interfaces.*;
import tn.esprit.service.impl.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "competanceBean", eager = true)
@SessionScoped
public class CompetanceBean implements Serializable {

	
	
	private static final long serialVersionUID = 100389L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String name;
	private int niveau;
	private String Description;
	private Integer useroyeIdToBeUpdated;
    private List<Competance>competances;
    private Type type;
	@EJB
	CompetanceService fms;

	public String redADD() {
		return "ajout";

	}

	public String redModify(Competance competance) {
		this.setName(competance.getName());
		this.setDescription(competance.getDescription());
		this.setType(competance.getType());
		this.setUseroyeIdToBeUpdated(competance.getId());
		
		return "Modify?faces-redirect=true";

	}

	public String updatecompetance()
  	{ fms.updateCompetance(new Competance(  useroyeIdToBeUpdated, name ,Description,type));
  	return "index";
  	}

	public String addcompetance() {
		Competance competance = new Competance(name,Description,type);
		fms.addCompetance(competance);
		return "index";
	}

	public void deletecompetance(int id) {
		fms.removeCompetance(id);
	}

	public void setUseroyeIdToBeUpdated(Integer useroyeIdToBeUpdated) {
		this.useroyeIdToBeUpdated = useroyeIdToBeUpdated;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getUseroyeIdToBeUpdated() {
		return useroyeIdToBeUpdated;
	}

	public List<Competance> getCompetances() {
		competances = fms.getAllCompetances();
		

		return competances;
	}

	public void setCompetances(List<Competance> competances) {
		this.competances = competances;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	

}
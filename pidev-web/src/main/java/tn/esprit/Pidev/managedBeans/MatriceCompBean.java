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
@ManagedBean(name = "matriceCompBean", eager = true)
@SessionScoped
public class MatriceCompBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
  
	private Category category;
	private String Description;
	private FicheMetier ficheMetier;
	private List<Competance> competances;
	private List<Competance> competances2;
	private List<MatriceComp> matriceComps;
	private int matriceid;
	private Integer useroyeIdToBeUpdated;
	@EJB
	MatriceCompService fms;
	@EJB
	CompetanceService cms;
	public String redADD() {
		return "ajout";

	}public String redirectionListComp() {
		competances2 =cms.getAllCompetances();
		
		for(Competance x : competances) 
		{
           
          if  (competances2.contains(x))
          {
        	  
        	  competances2.remove(x);
          }
          else
          {
        	  
        	  System.out.println("false");
        	  
          }
			
		
		}
			
		
		return "Listcomp?faces-redirect=true";

	} 
	public void ajoutComp(int competanceid) 
	{
		
			
		fms.affecterCompetanceAmatrice(competanceid, matriceid);
		competances2.remove(cms.getCompetanceById(competanceid));}
	
		
	
	public List<Competance> getCompetances2() {
		
		return competances2;
	}
    public List<Competance> getCompetances() {
		
		competances = fms.getAllCompetances(matriceid);
		return competances;
	} 
    
	public String reddvoirListCompetances(int id) 
	{
		this.matriceid=id;
		
		return "voirListComp?faces-redirect=true";
	}
	public String ajouterCompVersMat() 
	{ 
		
		
		return "Listcomp";
		
	}

	public String redModify(MatriceComp MatriceComp) {
		this.setCategory(MatriceComp.getCategory());
		this.setDescription(MatriceComp.getDescription());
		this.setUseroyeIdToBeUpdated(MatriceComp.getId());
		return "Modify";

	}

	public String updateMatriceComp()
  	{ fms.updateMatriceComp(new MatriceComp(  useroyeIdToBeUpdated, category ,Description));
  	return "index";
  	}

	public String addMatriceComp() {
		MatriceComp MatriceComp = new MatriceComp(category,Description);
		fms.addMatriceComp(MatriceComp);
		return "index";
	}

	public void deleteMatriceComp(int id) {
		fms.removeMatriceComp(id);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public FicheMetier getFicheMetier() {
		return ficheMetier;
	}

	public void setFicheMetier(FicheMetier ficheMetier) {
		this.ficheMetier = ficheMetier;
	}

	

	public void setCompetances(List<Competance> competances) {
		this.competances = competances;
	}

	public List<MatriceComp> getMatriceComps() {
		matriceComps = fms.getAllMatriceComps();
		return matriceComps;
	}
	

	public void setMatriceComps(List<MatriceComp> matriceComps) {
		this.matriceComps = matriceComps;
	}

	public Integer getUseroyeIdToBeUpdated() {
		return useroyeIdToBeUpdated;
	}

	public void setUseroyeIdToBeUpdated(Integer useroyeIdToBeUpdated) {
		this.useroyeIdToBeUpdated = useroyeIdToBeUpdated;
	}

	public int getMatriceid() {
		return matriceid;
	}

	public void setMatriceid(int matriceid) {
		this.matriceid = matriceid;
	}
	
	public void setCompetances2(List<Competance> competances2) {
		this.competances2 = competances2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((competances == null) ? 0 : competances.hashCode());
		result = prime * result + ((competances2 == null) ? 0 : competances2.hashCode());
		result = prime * result + ((matriceComps == null) ? 0 : matriceComps.hashCode());
		result = prime * result + matriceid;
		result = prime * result + ((useroyeIdToBeUpdated == null) ? 0 : useroyeIdToBeUpdated.hashCode());
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
		MatriceCompBean other = (MatriceCompBean) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (category != other.category)
			return false;
		if (competances == null) {
			if (other.competances != null)
				return false;
		} else if (!competances.equals(other.competances))
			return false;
		if (competances2 == null) {
			if (other.competances2 != null)
				return false;
		} else if (!competances2.equals(other.competances2))
			return false;
		if (matriceComps == null) {
			if (other.matriceComps != null)
				return false;
		} else if (!matriceComps.equals(other.matriceComps))
			return false;
		if (matriceid != other.matriceid)
			return false;
		if (useroyeIdToBeUpdated == null) {
			if (other.useroyeIdToBeUpdated != null)
				return false;
		} else if (!useroyeIdToBeUpdated.equals(other.useroyeIdToBeUpdated))
			return false;
		return true;
	}
	
	
	
	
}

package managedbeans;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Criteria;
import services.CriteriaService;


@ManagedBean(name = "criteriaBean")
@SessionScoped
public class CriteriaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private int idCriteria ;
	
	
	public CriteriaBean() {
		
	}

	

	public CriteriaBean(String name, String description, int idCriteria) {
		this.name = name;
		this.description = description;
		this.idCriteria = idCriteria;
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

	@EJB
	CriteriaService criteriaService;
	//add function
	public void addCriteria() {
		Criteria C=new Criteria(name, description);
		System.out.println(C);
		criteriaService.ajouterCriteria(C);
	}
	//show function
	private List<Criteria> criterias;
	
	public void setCriterias(List<Criteria> criterias) {
		this.criterias = criterias;
	}

	public List<Criteria> getCriterias() {
		criterias = criteriaService.getAllCriterias();
		return criterias;
		} 
	
	public void removeCriteria(int criteriaId)
	{
	criteriaService.deleteCriteriaById(criteriaId);
	}
	
	private Integer criteriaIdToBeUpdated;
	
	
	public Integer getCriteriaIdToBeUpdated() {
		return criteriaIdToBeUpdated;
	}



	public void setCriteriaIdToBeUpdated(Integer criteriaIdToBeUpdated) {
		this.criteriaIdToBeUpdated = criteriaIdToBeUpdated;
	}



	public void displayCriteria(Criteria ctrt)
	{
	this.setName(ctrt.getName());
	this.setDescription(ctrt.getDescription());
	this.setCriteriaIdToBeUpdated(ctrt.getIdCriteria());
	}
	
	public void updateCriteria()
	{ criteriaService.updateCriteria(new Criteria(criteriaIdToBeUpdated, name, description)); } 

}

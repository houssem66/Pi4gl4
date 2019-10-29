package tn.esprit.Pidev.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.entity.*;
import tn.esprit.service.interfaces.*;
import tn.esprit.service.impl.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "ficheMetierBean", eager = true)
@SessionScoped
public class FicheMetierBean implements Serializable {

	private static final long serialVersionUID = 100389L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String nom;
	private String description;
	private String employeNom="";
	private int Emplyeid;
	private int matriceid;
	private Category category;
	private Employe employe;
	private MatriceComp matriceComp;
	private List<FicheMetier> fiches;
	private Integer useroyeIdToBeUpdated;
	private FicheMetier fiche;
    private MatriceComp mat;
	@EJB
	FicheMetierService fms;

	@EJB
	EmployeService emps;

	@EJB
	MatriceCompService mats;

	public void setFiches(List<FicheMetier> fichess) {
		this.fiches = fichess;
	}

	public List<FicheMetier> getFiches() {

		fiches = fms.getAllFicheMetiers();
		return fiches;
	}

	public String redADD() {
		return "ajout";

	}
	public String redAffectation(FicheMetier fi) {
		this.fiche=fi;
		return "Affecter";

	}
	public String AffecterMat() 
	{   
		fms.affecterMat(mats.getMatriceCompByCategory(category), fiche);
	
		return "index";
	}


	public String redModify(FicheMetier fiche) {
		this.setNom(fiche.getName());
		this.setDescription(fiche.getDescription());
		this.setUseroyeIdToBeUpdated(fiche.getId());
		return "Modify";

	}

	public String updateFiche() {
		fms.updateFicheMetier(new FicheMetier(useroyeIdToBeUpdated, nom, description )
				);
		return "index";
	}

	public String addFicheMetier() {
		FicheMetier fiche = new FicheMetier(nom, description);
		fms.addFicheMetier(fiche);
		return "index";
	}
	

	public void deletefiche(int id) {
		fms.removeFicheMetier(id);
	}

	public int getEmplyeid() {
		return Emplyeid;
	}

	public void setEmplyeid(int emplyeid) {
		Emplyeid = emplyeid;
	}

	public int getMatriceid() {
		return matriceid;
	}

	public void setMatriceid(int matriceid) {
		this.matriceid = matriceid;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FicheMetierService getFms() {
		return fms;
	}

	public void setFms(FicheMetierService fms) {
		this.fms = fms;
	}

	public Integer getUseroyeIdToBeUpdated() {
		return useroyeIdToBeUpdated;
	}

	public void setUseroyeIdToBeUpdated(Integer useroyeIdToBeUpdated) {
		this.useroyeIdToBeUpdated = useroyeIdToBeUpdated;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public MatriceComp getMatriceComp() {
		return matriceComp;
	}

	public void setMatriceComp(MatriceComp matriceComp) {
		this.matriceComp = matriceComp;
	}

	public String getEmployeNom() {
		return employeNom;
	}

	public void setEmployeNom(String employeNom) {
		this.employeNom = employeNom;
	}

	public FicheMetier getFiche() {
		return fiche;
	}

	public void setFiche(FicheMetier fiche) {
		this.fiche = fiche;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MatriceComp getMat() {
		return mat;
	}

	public void setMat(MatriceComp mat) {
		this.mat = mat;
	}
	
	
	
}
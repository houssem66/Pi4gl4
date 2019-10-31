import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import entities.Tache;
import entities.Tache.Etat;
import entities.Timesheet;
import services.TacheService;
import services.TimesheetService;

import javax.faces.bean.*;


@ManagedBean(name="tacheBean")
@SessionScoped
public class TacheBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private String nom;
	 private String DateDeDebut;
	 private Double nbrDHeuresEstimes;
	 private Etat etat=Etat.en_arrêt;private List<Tache> taches;
	 private int priorite=0;
	 private boolean p;
	 private Etat[] etats=Etat.values();
	 
	 @EJB
	TacheService tacheService;
	 @EJB
	TimesheetService timesheetService; 
	 
	public String addTache()
	{ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	  Date date1,date3;
	try {
		date1 = sdf.parse(DateDeDebut);
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+00:00"), Locale.FRANCE);
		Date date2=calendar.getTime();
		String dateString=DateFormat.getDateInstance().format(date2);
		
		if (date1.compareTo(date2)==0) etat=Etat.en_cours;
		Timesheet timesheet=new Timesheet(); //à récupéréer de timesheetBean
		timesheet=timesheetService.findById(1); //statiquement
		if (p==true) priorite=1;
		Tache t=new Tache(nom,date1,nbrDHeuresEstimes,etat,priorite,timesheet);
		tacheService.add(t); 
		final int id=t.getId();
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "/resources/tacheIHM/affichageToutTaches";
	}
	
	private Integer tacheIdToBeUpdated;
	
	public String displayTache(Tache empl)
	{
	
	this.setNom(empl.getNom());
	this.setDateDeDebut(empl.getDateDeDebut().toString());
	this.setNbrDHeuresEstimes(empl.getNombreDheuresEstimes());
	if (empl.getPriorite()==0) this.setP(false);
	else this.setP(true);
	this.setTacheIdToBeUpdated(empl.getId());

	
return "modificationTache";
	
	}
	
	
	public String updateTache()
	{ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	  Date date1;
	try {
		date1 = sdf.parse(DateDeDebut);
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+00:00"), Locale.FRANCE);
		Date date2=calendar.getTime();
		String dateString=DateFormat.getDateInstance().format(date2);
		
		if (date1.compareTo(date2)==0) etat=Etat.en_cours;
		Timesheet timesheet=new Timesheet(); //à récupéréer de timesheetBean
		if (p==true) priorite=1;
		 tacheService.update(new Tache(tacheIdToBeUpdated, nom, date1,nbrDHeuresEstimes,etat,priorite,timesheet));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "affichageToutTaches";
	} 
	
	public void deleteTache(int id)
	{
		tacheService.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateDeDebut() {
		return DateDeDebut;
	}

	public void setDateDeDebut(String dateDeDebut) {
		DateDeDebut = dateDeDebut;
	}

	public Double getNbrDHeuresEstimes() {
		return nbrDHeuresEstimes;
	}

	public void setNbrDHeuresEstimes(Double nbrDHeuresEstimes) {
		this.nbrDHeuresEstimes = nbrDHeuresEstimes;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public TacheService getTacheService() {
		return tacheService;
	}

	public void setTacheService(TacheService tacheService) {
		this.tacheService = tacheService;
	}

	public List<Tache> getTaches() {
		return tacheService.findAll();
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public boolean isP() {
		return p;
	}

	public void setP(boolean p) {
		this.p = p;
	}

	public Etat[] getEtats() {
		return etats;
	}

	public void setEtats(Etat[] etats) {
		this.etats = etats;
	}


	public Integer getTacheIdToBeUpdated() {
		return tacheIdToBeUpdated;
	}


	public void setTacheIdToBeUpdated(Integer tacheIdToBeUpdated) {
		this.tacheIdToBeUpdated = tacheIdToBeUpdated;
	}
	
	
	
}

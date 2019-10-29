package tn.esprit.service.interfaces;
import java.util.List;

import tn.esprit.entity.*;

public interface IEmployeServiceLocale {

	public void addEmploye(Employe employe);
	public Employe getEmployeById(int id);
	public void removeEmploye(int id);
	public Employe updateEmploye(Employe employe);
	public List<Employe> getAllEmployes();
}

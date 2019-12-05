package tn.esprit.service.interfaces;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entity.*;
@Remote
public interface IEmployeServiceRemote {

	public void addEmploye(Employe employe);
	public Employe getEmployeById(int id);
	public void removeEmploye(int id);
	public Employe updateEmploye(Employe employe);
	public List<Employe> getAllEmployes();
}

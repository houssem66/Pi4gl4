package tn.esprit.service.impl;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.entity.*;

import tn.esprit.service.interfaces.IEmployeServiceRemote;

@LocalBean

@Stateless
public class EmployeService implements IEmployeServiceRemote{

@PersistenceContext(unitName="pidev-ejb")
	
	EntityManager em ;
	@Override
	public void addEmploye(Employe employe) {
		em.persist(employe);
		
	}

	@Override
	public Employe getEmployeById(int id) {
		// TODO Auto-generated method stub
		return em.find(Employe.class, id);
	}

	@Override
	public void removeEmploye(int id) {
		// TODO Auto-generated method stub
		Employe Employe =getEmployeById(id);
		em.remove(Employe);
	}

	@Override
	public Employe updateEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return em.merge(employe);
	}

	@Override
	public List<Employe> getAllEmployes() {
		// TODO Auto-generated method stub
		return em.createQuery("from Employe", Employe.class).getResultList();
	}

}

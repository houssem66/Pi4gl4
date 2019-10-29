package tn.esprit.service.impl; 
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.entity.*;
import tn.esprit.service.interfaces.ICompetanceServiceLocale;

@LocalBean

@Stateless
public class CompetanceService implements ICompetanceServiceLocale{

@PersistenceContext(unitName="pidev-ejb")
	
	EntityManager em ;

	@Override
	public void addCompetance(Competance competance) {
		
		em.persist(competance);
		
	}

	@Override
	public Competance getCompetanceById(int id) {
		// TODO Auto-generated method stub
		return em.find(Competance.class, id);
	}

	@Override
	public void removeCompetance(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Competance.class, id));
		System.out.println("Deleted!!!");
	}

	@Override
	public void updateCompetance(Competance competance) {
		Competance us= em.find(Competance.class,competance.getId());
		System.out.println("Updated !!"+competance.getId());
		us.setName(competance.getName());
		us.setDescription(competance.getDescription());
		us.setType(competance.getType());
		
		
		
	}

	@Override
	public List<Competance> getAllCompetances() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c from Competance c", Competance.class).getResultList();
	}

}

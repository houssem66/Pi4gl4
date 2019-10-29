package tn.esprit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import tn.esprit.entity.*;
import tn.esprit.service.interfaces.IMatriceCompServiceLocale;

@LocalBean

@Stateless
public class MatriceCompService implements IMatriceCompServiceLocale {

	@PersistenceContext(unitName = "pidev-ejb")

	EntityManager em;

	@Override
	public void addMatriceComp(MatriceComp matriceComp) {
		em.persist(matriceComp);

	}

	@Override
	public MatriceComp getMatriceCompById(int id) {
		// TODO Auto-generated method stub
		return em.find(MatriceComp.class, id);
	}

	@Override
	public void removeMatriceComp(int id) {
		// TODO Auto-generated method stub
		MatriceComp matriceComp = getMatriceCompById(id);
		em.remove(matriceComp);
	}

	@Override
	public void updateMatriceComp(MatriceComp matriceComp) {
		MatriceComp us = em.find(MatriceComp.class, matriceComp.getId());
		System.out.println("Updated !!" + matriceComp.getId());
		us.setCategory(matriceComp.getCategory());
		us.setDescription(matriceComp.getDescription());

	}

	@Override
	public List<MatriceComp> getAllMatriceComps() {
		// TODO Auto-generated method stub
		return em.createQuery("from MatriceComp", MatriceComp.class).getResultList();
	}
	
	@Override
	public List<Competance> getAllCompetances(int marticeid) {
		
		
		List<Competance> competances = em.find(MatriceComp.class, marticeid).getCompetances();
		return competances ;
	}

	public void affecterCompetanceAmatrice(int competanceid, int matriceid/*, int niveau*/) {
		Competance compAajout = em.find(Competance.class, competanceid);
		MatriceComp matManagedEntity = em.find(MatriceComp.class, matriceid);

		if (matManagedEntity.getCompetances() == null) {
			List<Competance> competances = new ArrayList<>();
			//compAajout.setNiveau(niveau);
			competances.add(compAajout);
			matManagedEntity.setCompetances(competances);
			;
		} else {
			matManagedEntity.getCompetances().add(compAajout);
		}

	}

	@Override
	public MatriceComp getMatriceCompByCategory(Category category) {

		Query query = em.createQuery("select m from MatriceComp m where m.category = :category");
		query.setParameter("category", category);
		MatriceComp c = (MatriceComp) query.getSingleResult();
		System.out.println("fuck !" + c.getCategory()+c.getId());
		return c;
	}

}

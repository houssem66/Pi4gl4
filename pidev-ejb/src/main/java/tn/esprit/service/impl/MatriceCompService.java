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
import tn.esprit.service.interfaces.IMatriceCompServiceRemote;

@LocalBean

@Stateless
public class MatriceCompService implements IMatriceCompServiceRemote {

	@PersistenceContext(unitName = "pidev-ejb")

	EntityManager em;

	@Override
	public int addMatriceComp(MatriceComp matriceComp) {
		em.persist(matriceComp);
        return matriceComp.getId();
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
		
		us.setDescription(matriceComp.getDescription());

	}

	@Override
	public List<MatriceComp> getAllMatriceComps() {
		// TODO Auto-generated method stub
		return em.createQuery("from MatriceComp", MatriceComp.class).getResultList();
	}

}

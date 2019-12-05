package tn.esprit.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.entity.NiveauxFiche;
import tn.esprit.entity.NiveauxMatPk;
import tn.esprit.entity.NiveauxMat;
import tn.esprit.entity.NiveauxMat;
import tn.esprit.service.interfaces.INiveauxMatServiceRemote;
@LocalBean
@Stateless
public class NiveauxMatService implements INiveauxMatServiceRemote {
@PersistenceContext(unitName="pidev-ejb")
	
	EntityManager em ;
@Override
public void addNiveauxMat(int idComp, int idMat,int niveau) {
	
	NiveauxMatPk niveauxMatPk = new NiveauxMatPk();
	niveauxMatPk.setIdComp(idComp);
	niveauxMatPk.setIdMat(idMat);
	NiveauxMat niveauxMat = new NiveauxMat();
	niveauxMat.setNiveauxMatPk(niveauxMatPk);
	niveauxMat.setNiveaux(niveau);
	em.persist(niveauxMat);
	
}

@Override
public NiveauxMat getNiveauxMatById(int id) {
	// TODO Auto-generated method stub
	return em.find(NiveauxMat.class, id);
}

@Override
public void removeNiveauxMat(int idcom,int idMat) {
	NiveauxMatPk pk = new NiveauxMatPk(idcom,idMat);
	em.remove(em.find(NiveauxMat.class, pk));
	System.out.println("Deleted!!!");
}

@Override
public void updateNiveauxMat(NiveauxMat NiveauxMat) {
	/*NiveauxMat us= em.find(NiveauxMat.class,NiveauxMat.getId());
	System.out.println("Updated !!"+NiveauxMat.getId());
	us.setName(NiveauxMat.getName());
	us.setDescription(NiveauxMat.getDescription());
	us.setType(NiveauxMat.getType());
	*/
	
	
}

@Override
public List<NiveauxMat> getAllNiveauxMats() {
	// TODO Auto-generated method stub
	return em.createQuery("SELECT c from NiveauxMat c", NiveauxMat.class).getResultList();
}


}

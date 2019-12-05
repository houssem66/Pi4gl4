package tn.esprit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.entity.Competance;
import tn.esprit.entity.Employe;
import tn.esprit.entity.FicheMetier;
import tn.esprit.entity.MatriceComp;
import tn.esprit.entity.NiveauxFiche;
import tn.esprit.entity.NiveauxFichePk;
import tn.esprit.entity.NiveauxFiche;
import tn.esprit.entity.NiveauxFiche;
import tn.esprit.service.interfaces.INiveauxFicheServiceRemote;
@LocalBean
@Stateless
public class NiveauxFicheService implements INiveauxFicheServiceRemote {
@PersistenceContext(unitName="pidev-ejb")
	
	EntityManager em ;
@Override
public void addNiveauxFiche(int idComp, int idMat,int niveau) {
	
	NiveauxFichePk NiveauxFichePk = new NiveauxFichePk();
	NiveauxFichePk.setIdComp(idComp);
	NiveauxFichePk.setIdFiche(idMat);
	NiveauxFiche NiveauxFiche = new NiveauxFiche();
	NiveauxFiche.setNiveauxFichePk(NiveauxFichePk);
	NiveauxFiche.setNiveaux(niveau);
	em.persist(NiveauxFiche);
	
}

@Override
public NiveauxFiche getNiveauxFicheByIdFiche(int id) {
	// TODO Auto-generated method stub
	return em.find(NiveauxFiche.class, id);
}

@Override
public void removeNiveauxFiche(int idcom,int idMat) {
	NiveauxFichePk pk = new NiveauxFichePk(idcom,idMat);
	em.remove(em.find(NiveauxFiche.class, pk));
	System.out.println("Deleted!!!");
}

@Override
public void updateNiveauxFiche(NiveauxFiche NiveauxFiche) {
	/*NiveauxFiche us= em.find(NiveauxFiche.class,NiveauxFiche.getId());
	System.out.println("Updated !!"+NiveauxFiche.getId());
	us.setName(NiveauxFiche.getName());
	us.setDescription(NiveauxFiche.getDescription());
	us.setType(NiveauxFiche.getType());
	*/
	
	
}


@Override
public List<Competance> getAllCompetancesByFicheId(int id) {
	System.out.println("jojklk");
	//List<Competance> competances = em.find(MatriceComp.class, marticeid).getCompetances();

	/*List <NiveauxFiche>  l = em.createQuery
			  ("SELECT n  FROM NiveauxFiche n WHERE m.niveauxFichePk.idFiche="+id,NiveauxFiche.class).getResultList();
	*/
	List <Competance>  l=new ArrayList<Competance>();
	  l=em.createQuery 
			  ("SELECT n.competance from NiveauxFiche n Where n.niveauxFichePk.idFiche="+id,Competance.class).getResultList();
	  ;
	 
	return l;
	  
}
}




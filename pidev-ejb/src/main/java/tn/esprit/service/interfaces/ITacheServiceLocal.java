package tn.esprit.service.interfaces; 

import java.util.List;

import javax.ejb.Local;
import javax.persistence.Table;

import entities.Reclammation;
import entities.Tache;

@Local
public interface ITacheServiceLocal {

	public void add(Tache bp);
	
	public void delete(int bp);
	public Tache findById(int id);
	public List<Tache> findAll();
	void update(Tache bp);

	
}

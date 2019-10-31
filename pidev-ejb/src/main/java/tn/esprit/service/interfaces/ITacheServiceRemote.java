package iservices;

import javax.ejb.Remote;

import entities.Tache;

@Remote
public interface ITacheServiceRemote {

	public void add(Tache bp);
	public void update(Tache bp);
	public void delete(int bp);
	public Tache findById(int id);
}

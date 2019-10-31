package tn.esprit.service.interfaces; 

import javax.ejb.Remote;

import entities.BonPoint;

@Remote
public interface IBonPointServiceRemote {
	public void add(BonPoint bp);
	public void update(BonPoint bp);
	public void delete(BonPoint bp);
	public BonPoint findById(int id);
}

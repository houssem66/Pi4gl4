package tn.esprit.service.interfaces; 

import javax.ejb.Local;

import entities.BonPoint;

@Local
public interface IBonPointServiceLocal {
public void add(BonPoint bp);
public void update(BonPoint bp);
public void delete(BonPoint bp);
public BonPoint findById(int id);
}

package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.BonPoint;
import entities.Notification;
import iservices.INotificationServiceLocal;
import iservices.INotificationServiceRemote;

@LocalBean
@Stateful
public class NotificationService implements INotificationServiceLocal,INotificationServiceRemote{

	@PersistenceContext(unitName = "advyteam")
	EntityManager em;

	@Override
	public void add(Notification bp) {
		// TODO Auto-generated method stub
		em.persist(bp);
		
	}

	@Override
	public void update(Notification bp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Notification bp) {
		em.remove(bp);
		
	}

	@Override
	public Notification findById(int id) {
		Notification bp=em.find(Notification.class, id);
		return bp;
	}
}

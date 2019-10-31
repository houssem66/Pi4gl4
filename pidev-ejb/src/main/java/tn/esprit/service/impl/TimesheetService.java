package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Reclammation;
import entities.Timesheet;
import iservices.ITimesheetServiceLocal;
import iservices.ITimesheetServiceRemote;

@LocalBean
@Stateful
public class TimesheetService implements ITimesheetServiceLocal,ITimesheetServiceRemote {

	@PersistenceContext(unitName = "advyteam")
	EntityManager em;

	@Override
	public void add(Timesheet bp) {
		// TODO Auto-generated method stub
		em.persist(bp);
		
	}

	@Override
	public void update(Timesheet bp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Timesheet bp) {
		em.remove(bp);
		
	}

	@Override
	public Timesheet findById(int id) {
		Timesheet bp=em.find(Timesheet.class, id);
		return bp;
	}
}

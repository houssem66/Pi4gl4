package tn.esprit.service.interfaces; 

import javax.ejb.Local;

import entities.Tache;
import entities.Timesheet;

@Local
public interface ITimesheetServiceLocal {

	public void add(Timesheet  bp);
	public void update(Timesheet bp);
	public void delete(Timesheet bp);
	public Timesheet findById(int id);
}

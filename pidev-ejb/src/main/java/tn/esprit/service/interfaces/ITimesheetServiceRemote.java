package tn.esprit.service.interfaces; 

import javax.ejb.Remote;

import entities.Timesheet;

@Remote
public interface ITimesheetServiceRemote {

	public void add(Timesheet  bp);
	public void update(Timesheet bp);
	public void delete(Timesheet bp);
	public Timesheet findById(int id);
}

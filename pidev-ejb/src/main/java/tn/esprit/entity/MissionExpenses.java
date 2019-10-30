package tn.esprit.mission.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Expenses")
public class MissionExpenses implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private int housing;
	private int visaExpenses;
	private int restoration;
	private int transport;

	public MissionExpenses() {

	}

	public MissionExpenses( int housing, int visaExpenses, int restoration, int transport) {
		super();
		
		this.housing = housing;
		this.visaExpenses = visaExpenses;
		this.restoration = restoration;
		this.transport = transport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHousing() {
		return housing;
	}

	public void setHousing(int housing) {
		this.housing = housing;
	}

	public int getVisaExpenses() {
		return visaExpenses;
	}

	public void setVisaExpenses(int visaExpenses) {
		this.visaExpenses = visaExpenses;
	}

	public int getRestoration() {
		return restoration;
	}

	public void setRestoration(int restoration) {
		this.restoration = restoration;
	}

	public int getTransport() {
		return transport;
	}

	public void setTransport(int transport) {
		this.transport = transport;
	}

	@Override
	public String toString() {
		return "MissionExpenses [id=" + id + ", housing=" + housing + ", visaExpenses=" + visaExpenses
				+ ", restoration=" + restoration + ", transport=" + transport + "]";
	}
	

}

package tn.esprit.mission.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mission")
public class Mission implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	private MissionPolicy missionPolicy;

	private String name;
	private String description;


	




	public Mission(MissionPolicy missionPolicy, String name, String description) {
		super();
		this.missionPolicy = missionPolicy;
		this.name = name;
		this.description = description;
	}





	public Mission(int id, MissionPolicy missionPolicy, String name, String description) {
		super();
		this.id = id;
		this.missionPolicy = missionPolicy;
		this.name = name;
		this.description = description;
	}





	public Mission() {
		super();
	}





	public Mission(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MissionPolicy getMissionPolicy() {
		return missionPolicy;
	}

	public void setMissionPolicy(MissionPolicy missionPolicy) {
		this.missionPolicy = missionPolicy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Mission [id=" + id + ", missionPolicy=" + missionPolicy + ", name=" + name + ", description="
				+ description + "]";
	}

}

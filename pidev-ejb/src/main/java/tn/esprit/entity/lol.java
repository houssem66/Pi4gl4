package tn.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
public class lol {
	@Id
	
	private int id;
	private String name;
	public String getName() {
		return name;
	}@XmlAttribute(name="name")
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}@XmlAttribute(name="id")
	public void setId(int id) {
		this.id = id;
	}
}

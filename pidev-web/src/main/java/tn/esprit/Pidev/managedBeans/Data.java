import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import entities.Tache.Etat;

@ManagedBean("data")
@ApplicationScoped
public class Data implements Serializable {
private static final long serialVersionUID = 1L;
private Etat[] etats=Etat.values();

public void setEtats(Etat[] etats) {
	this.etats = etats;
}

public Etat[] getEtats() { return this.etats; }
}
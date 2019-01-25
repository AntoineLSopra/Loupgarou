package fr.loupgarou.model;

import javax.persistence.*;

//JOINED
@Entity
@Table(name="administrateur")
@PrimaryKeyJoinColumn(name="ADM_ID", referencedColumnName="UTI_ID")

public class Administrateur extends Utilisateur {

	public boolean isAdmin() {
		return true;
	}
	
}

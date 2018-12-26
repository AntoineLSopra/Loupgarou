package fr.loupgarou.model;

import javax.persistence.*;


//JOINED
@Entity
@Table(name="joueur")
@PrimaryKeyJoinColumn(name="JOU_ID", referencedColumnName="UTI_ID")

public class Joueur extends Utilisateur {
	
	
	private Boolean Banni = false; 
	
	
	
	public Boolean isBanni() {
		return Banni;
	}
	public void setBanni(Boolean banni) {
		Banni = banni;
	}
	
	
	

	
//	public static Joueur creerJoueur(String pseudo, Boolean Banni) {
//		Joueur j = new Joueur();
//		j.setPseudo(pseudo);
//		j.isBanni();
//		return j;
//	}

}

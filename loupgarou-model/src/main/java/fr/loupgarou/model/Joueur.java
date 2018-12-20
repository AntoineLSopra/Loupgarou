package fr.loupgarou.model;

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

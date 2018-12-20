package fr.loupgarou.model;

public class Joueur extends Utilisateur{
	private String Pseudo = "";
	private Boolean Banni = false; 
	
	public String getPseudo() {
		return Pseudo;
	}
	public void setPseudo(String joueur) {
		Pseudo = joueur;
	}
	public Boolean isBanni() {
		return Banni;
	}
	public void setBanni(Boolean banni) {
		Banni = banni;
	}
	
	public static Joueur creerJoueur(String pseudo, Boolean Banni) {
		Joueur j = new Joueur();
		j.setPseudo(pseudo);
		j.isBanni();
		return j;
	}

}

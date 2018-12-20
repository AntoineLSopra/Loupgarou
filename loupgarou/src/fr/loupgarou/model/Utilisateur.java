package fr.loupgarou.model;

public class Utilisateur {
	private int id = 0;
	private String nom = "";
	private String prenom = "";
	private String username = "";
	private String password = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public static Utilisateur inscrire(String nom, String prenom, String username, String password) {
		Utilisateur u = new Utilisateur();
		u.setPrenom(prenom);
		u.setNom(nom);
		u.setUsername(username);
		u.setPassword(password);
		return u;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + this.id;
	}
	
//	public static Utilisateur connexion(String username, String password) {
//		
//	}
	
//	public static Joueur creerJoueur(String prenom, String nom, Integer age) {
//		Joueur j = new Joueur();
//		j.setPrenom(prenom);
//		j.setNom(nom); 
//		j.setAge(age); 
//		return j;
//	}

}

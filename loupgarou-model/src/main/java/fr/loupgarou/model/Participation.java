package fr.loupgarou.model;

import javax.persistence.*;

public class Participation {
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="PTN_PARTIE_ID")
	private Partie partie;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="PTN_JOUEUR_ID")
	private Joueur joueur;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="PTN_PERSONNAGE_ID")
	private Personnage personnage;

	@Enumerated (EnumType.ORDINAL)
	private Role role = Role.LOUP;

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}
	
	
	
	
}

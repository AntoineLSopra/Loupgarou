package fr.loupgarou.model;

import java.util.List;

import javax.persistence.*;


//JOINED
@Entity
@Table(name="joueur")
@PrimaryKeyJoinColumn(name="JOU_ID", referencedColumnName="UTI_ID")

public class Joueur extends Utilisateur {
	@OneToMany(mappedBy = "joueur")
	private List<Message> discussion;
	
	@Column(name="JOU_BANNI")
	private Boolean banni = false; 



	public Boolean isBanni() {
		return banni;
	}
	public void setBanni(Boolean banni) {
		banni = this.banni;
	}
	public List<Message> getDiscussion() {
		return discussion;
	}
	public void setDiscussion(List<Message> discussion) {
		this.discussion = discussion;
	}
	
	
	
	

	
//	public static Joueur creerJoueur(String pseudo, Boolean Banni) {
//		Joueur j = new Joueur();
//		j.setPseudo(pseudo);
//		j.isBanni();
//		return j;
//	}

}

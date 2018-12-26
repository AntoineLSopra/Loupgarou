package fr.loupgarou.model;

import javax.persistence.*;

@Entity
@Table(name="partie")

public class Partie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAR_ID")
	private int id;
	
	//A FAIRE
	private Histoire histoire;
	
	//A FAIRE
	private Joueur capitaine;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Histoire getHistoire() {
		return histoire;
	}
	public void setHistoire(Histoire histoire) {
		this.histoire = histoire;
	}
	public Joueur getCapitaine() {
		return capitaine;
	}
	public void setCapitaine(Joueur capitaine) {
		this.capitaine = capitaine;
	}



	


}

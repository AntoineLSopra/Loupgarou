package fr.loupgarou.model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="Histoire")

public class Histoire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HIS_ID")
	private int id;
	
	@Column(name="HIS_LIBELLE")
	private String libelle;

	//A Faire
	private ArrayList<Joueur> main;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@OneToMany(mappedBy = "partie")
	public ArrayList<Joueur> getMain() {
		return main;
	}
	public void setMain(ArrayList<Joueur> main) {
		this.main = main;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + this.id;
	}
	
	
	
}

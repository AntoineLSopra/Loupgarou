package fr.loupgarou.model;

import java.util.ArrayList;
import java.util.List;

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
	
	@ManyToMany
	@JoinTable(name="histoires",
			uniqueConstraints=@UniqueConstraint(columnNames = {"LIST_HIST_ID", "LIST_PERSO_ID"}),
			joinColumns=@JoinColumn(name="LIST_HIST_ID", referencedColumnName="HIS_ID"),
			inverseJoinColumns=@JoinColumn(name="LIST_PERSO_ID",referencedColumnName="PER_ID"))
	private List<Personnage> personnages;

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
	public List<Personnage> getPersonnages() {
		return personnages;
	}
	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}
	
	
	
}

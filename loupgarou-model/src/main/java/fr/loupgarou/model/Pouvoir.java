package fr.loupgarou.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;



//JOINED
@Entity
@Table(name="pouvoir")

public class Pouvoir {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="POU_ID")
	private int id;
	
	@Column(name="POU_LIBELLE")
	@NotEmpty
	@Size(max=250)
	private String libelle;
	
	@ManyToMany(mappedBy="pouvoirs")
    private List<Personnage> personnages;
	
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
	
}

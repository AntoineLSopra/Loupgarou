package fr.loupgarou.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="personnage")

public class Personnage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PER_ID")
	private int id;
	@Column(name="PER_LIBELLE")
	@NotEmpty
	@Size(max=250)
	private String libelle;

	@ManyToMany(mappedBy="personnages")
    private List<Histoire> histoires;
	
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
	public List<Histoire> getHistoires() {
		return histoires;
	}
	public void setHistoires(List<Histoire> histoires) {
		this.histoires = histoires;
	}
	
	
	
}

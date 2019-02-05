package fr.loupgarou.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import fr.loupgarou.projection.Views;

@Entity
@Table(name="personnage")

public class Personnage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PER_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="PER_LIBELLE")
	@NotEmpty
	@Size(max=250)
	@JsonView(Views.Common.class)
	private String libelle;

	@ManyToMany(mappedBy="personnages")
    private List<Histoire> histoires;
	
	@ManyToMany
	@JoinTable(name="tablepouvoirs",
			uniqueConstraints=@UniqueConstraint(columnNames = {"TAB_POUV_ID", "TAB_PERSO_ID"}),
			joinColumns=@JoinColumn(name="TAB_PERSO_ID", referencedColumnName="PER_ID"),
			inverseJoinColumns=@JoinColumn(name="TAB_POUV_ID",referencedColumnName="POU_ID"))
	private List<Pouvoir> pouvoirs;
	
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
	public List<Pouvoir> getPouvoirs() {
		return pouvoirs;
	}
	public void setPouvoirs(List<Pouvoir> pouvoirs) {
		this.pouvoirs = pouvoirs;
	}
	
	@Override
	public String toString() {
		return this.libelle;
	}
	
	
	
}

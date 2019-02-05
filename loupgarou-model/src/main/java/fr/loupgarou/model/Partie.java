package fr.loupgarou.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import fr.loupgarou.projection.Views;

@Entity
@Table(name="partie")

public class Partie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAR_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	//A FAIRE
	@ManyToOne //(cascade = CascadeType.PERSIST)
	@JoinColumn(name="PAR_HISTOIRE_ID")
	private Histoire histoire;
	
	//A FAIRE
	@ManyToOne
	@JoinColumn(name="PAR_CAPITAINE_ID")
	private Joueur capitaine;
	
	@OneToMany(mappedBy="partie")
	private List<Message> discussion;
	
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
	public List<Message> getDiscussion() {
		return discussion;
	}
	public void setDiscussion(List<Message> discussion) {
		this.discussion = discussion;
	}




	


}

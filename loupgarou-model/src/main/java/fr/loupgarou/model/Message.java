package fr.loupgarou.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import fr.loupgarou.projection.Views;


@Entity
@Table(name="message")

public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MES_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="MES_CONTENU", columnDefinition="TEXT")
	@JsonView(Views.Chat.class)
	private String contenu;
	
	@ManyToOne
	@JoinColumn(name="MES_PARTIE_ID")
	@JsonView(Views.Chat.class)
	private Partie partie;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="MES_JOUEUR_ID")
	@JsonView(Views.Chat.class)
	private Joueur joueur;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


}

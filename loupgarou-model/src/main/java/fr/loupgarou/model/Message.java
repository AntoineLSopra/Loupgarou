package fr.loupgarou.model;

import javax.persistence.*;


@Entity
@Table(name="message")

public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MES_ID")
	private int id;
	
	@Column(name="MES_CONTENU", columnDefinition="TEXT")
	private String contenu;
	

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


}

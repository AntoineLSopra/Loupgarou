package fr.loupgarou.model;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import fr.loupgarou.projection.Views;


//JOINED
@Entity
@Table(name="utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)


public class Utilisateur {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="UTI_ID")
		@JsonView(Views.Common.class)
		private int id;
		
		@Column(name="UTI_NOM")
		@NotEmpty
		@Size(max=250)
		private String nom;
		
		@Column(name="UTI_PRENOM")
		@Size(max=100)
		private String prenom;
		
		@Column(name="UTI_USERNAME")
		@NotEmpty
		@Size(max=250)
		@JsonView(Views.Participation.class)
		private String username;
		
		@Column(name="UTI_PASSWORD", length = 250, nullable=false)
		@NotEmpty
		@Size(max=250)
		private String password;
		
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public static Utilisateur inscrire(String nom, String prenom, String username, String password) {
			Utilisateur u = new Utilisateur();
			u.setPrenom(prenom);
			u.setNom(nom);
			u.setUsername(username);
			u.setPassword(password);
			return u;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.getUsername();
		}
		
		public boolean isAdmin() {
			return false;
		}
		
//		public static Utilisateur connexion(String username, String password) {
//			
//		}
//	
	
}

package fr.loupgarou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.*;
import fr.loupgarou.idao.sql.*;
import fr.loupgarou.dao.sql.*;
import fr.loupgarou.model.*;



public class PrincipalePartie {

	public static void main(String[] args) {
	
		//	findAll(): AFFICHER PARTIES	
//		afficherParties();
//		
//		//	findById(): TROUVER PARTIE
//		trouverPartie();
//			
//		//	save(): CREER UNE NOUVELLE PARTIE
//		sauvegarderPartie();
//			
//		//	save(): MODIFIER UNE PARTIE  
//		modifierPartie();
//			
//		//	deleteById(): SUPPRIMER PARTIE
//		supprimerPartie();
		
		sauvegarderHistoire();
			
	}
	
	public static void nouvellePartie() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPartie daoPartie = new DAOPartieSQL(emf);
		
		
	}
	
	public static void afficherParties() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPartie daoPartie = new DAOPartieSQL(emf);
		List<Partie> lesParties = daoPartie.findAll();
		
		System.out.println("----  DETAIL DES PARTIES  ----");
		
		for (Partie p : lesParties) {
			System.out.println("ID: " + p.getId());
			System.out.println("HISTOIRE: " + p.getHistoire());
			System.out.println("CAPITAINE: " + p.getCapitaine());
			System.out.println("--------------------------------");
		}
	}


	public static void trouverPartie() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPartie daoPartie = new DAOPartieSQL(emf);
		Partie laPartie = daoPartie.findById(1);
		System.out.println("Histoire: " + laPartie.getHistoire());
		System.out.println("Capitaine: " + laPartie.getCapitaine());
	}

	
	public static void sauvegarderPartie() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPartie daoPartie = new DAOPartieSQL(emf);

		Partie maPartie= new Partie();
		
		Histoire story = new Histoire();
		Joueur capitaine = new Joueur();
		story.setId(1);
		capitaine.setId(25);
		
		maPartie.setHistoire(story);
		maPartie.setCapitaine(capitaine);
		
		daoPartie.save(maPartie);
		emf.close();
	}
	
	public static void sauvegarderHistoire() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOHistoire daoHistoire = new DAOHistoireSQL(emf);

		
		Histoire nouvelHistoire = new Histoire();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Saisir un Libelle : ");
		String a = sc.next();
		nouvelHistoire.setLibelle(a);
		
		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL(emf);
		Personnage villageois = daoPersonnage.findById(1);
		Personnage loup = daoPersonnage.findById(2);
		
		List<Personnage> jeuDuVillage = new ArrayList<Personnage>();
		
		
		jeuDuVillage.add(villageois);
		jeuDuVillage.add(loup);
		nouvelHistoire.setPersonnages(jeuDuVillage);
		daoHistoire.save(nouvelHistoire);
		emf.close();
	}
	
	
	public static void modifierPartie() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPartie daoPartie = new DAOPartieSQL(emf);

		Joueur capitaine = new Joueur();
		capitaine.setId(26);
		
		Partie nouvellePartie = daoPartie.findById(16);
		
		nouvellePartie.setCapitaine(capitaine);
		daoPartie.save(nouvellePartie);
	}

	public static void supprimerPartie() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPartie daoPartie = new DAOPartieSQL(emf);
		daoPartie.deleteById(5);
	}
	

	
}

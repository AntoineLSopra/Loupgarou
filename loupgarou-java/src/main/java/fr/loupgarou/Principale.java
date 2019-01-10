package fr.loupgarou;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import fr.loupgarou.datajpa.IDAOUtilisateur;
import fr.loupgarou.model.*;

public class Principale {
		
	@Autowired(required = false)
	private IDAOUtilisateur daoUtilisateur;
	//@Transactional
	public void  run (String[] args)   {
		
		System.out.println("-----------  MENU  -----------");
		System.out.println("0 -  QUITTER");
		System.out.println("1 -  SE CONNECTER");
		System.out.println("2 -  S'INSCRIRE");
		System.out.println("choisir option: "); 
		int num = lireEntier();	
		
		while (num != 0) {
			if (num == 1) {
				connect();
			}
			else if (num == 2) {
				inscriptionJoueur();
			}	
			
			System.out.println("-----------  MENU  -----------");
			System.out.println("0 -  QUITTER");
			System.out.println("1 -  SE CONNECTER");
			System.out.println("2 -  S'INSCRIRE");
			System.out.println("choisir option: ");
			num= lireEntier();
		}

	}
		
	
//	--------------------------- SORTIES DU MENU--------------------------- 	//
		
	public void connect() {

	
		Scanner sc = new Scanner(System.in);	
			System.out.println("------------- Connexion ----------------");
			System.out.println("Username : ");
			String use = sc.next();
			System.out.println("Password : ");
			String pass = sc.next();	
			int i = connexion(use, pass);
			
		if (i == 1) {
			System.out.println("--------  MENU JOUEUR  --------");
			System.out.println("0 -  QUITTER");
			System.out.println("1 -  NOUVELLE PARTIE");
			System.out.println("2 -  REJOINDRE UNE PARTIE");
			System.out.println("choisir option: "); 
			int num= lireEntier();
			
			if (num == 1) {
				System.out.println("A FAIRE: NOUVELLE PARTIE");
			}
			
			else if (num == 2) {
				System.out.println("A FAIRE: REJOINDRE PARTIE");
			}
		}
			
		else if (i == 2) {
			System.out.println("--------  MENU ADMINISTRATEUR  --------");
			System.out.println("0 -  QUITTER");
			System.out.println("1 - TROUVER UTILISATEUR");
			System.out.println("choisir option: "); 
			int num= lireEntier();
			
			if (num == 1) {
				trouverUtilisateur();
			}
			
			else if (num == 2) {
				System.out.println("A FAIRE: ");
			}
		}	
	}
	
	

	public int connexion () {
	    int i = 0;
	//   System.out.println(daoUtilisateur.connexionJoueur("AntoineL", "0000"));
	    System.out.println(daoUtilisateur.connexionJoueur("Jerem", "0000"));
	    
	    if (daoUtilisateur.connexionJoueur(use, pass) != null) {
	      System.out.println("Bienvenue : " + use);
	      return i = 1;
	    }
	    if (daoUtilisateur.connexionAdministrateur(use, pass) != null) {
	      System.out.println("Bienvenue adm : " + use);
	      return i = 2;
	      
	    }
	    else {
	      System.out.println("Connexion échouée");
	      return i;
	    }
	  }

	public void inscriptionJoueur() {
	
	
		Utilisateur nouvelUtilisateur = new Joueur();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Saisir un Nom : ");
		String a = sc.next();
		nouvelUtilisateur.setNom(a);
		
		System.out.println("Saisir un Prénom : ");
		String b = sc.next();
		nouvelUtilisateur.setPrenom(b);
		
		System.out.println("Saisir un Username : ");
		String c = sc.next();
		nouvelUtilisateur.setUsername(c);
		
		System.out.println("Saisir un Password : ");
		String d = sc.next();
		nouvelUtilisateur.setPassword(d);
		
		daoUtilisateur.save(nouvelUtilisateur);
	
		System.out.println("Joueur Inscrit");
	}

	static int lireEntier() {
		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextInt();
		}

		catch (Exception ex) {
			return 0;
		}
	}
	
	public void trouverUtilisateur() {
	
	System.out.println("-----------------------RECHERCHE UTILISATEUR PAR ID------------------------");
	
		System.out.println("Entrer l'Id de l'utilisateur:"); 
		int i = lireEntier();
		for (Utilisateur u: ((IDAOUtilisateur)daoUtilisateur).findByUtilisateurId(i)) {
			System.out.println(u.getId() + " | " + u.getNom()+ " | " + u.getPrenom()); 
			System.out.println("---------------------------");
		}
	}
	

	
}
package fr.loupgarou;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import fr.loupgarou.datajpa.IDAOUtilisateur;
import fr.loupgarou.model.*;

public class Principale {
		
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	@Transactional
	public void  run (String[] args)   {
//		
//		System.out.println("-----------------------FIND BY UTILISATEUR ID------------------------");
//		System.out.println(daoUtilisateur.findById(25));
//		for (Utilisateur p: (daoUtilisateur).findByNom("")) {
//			System.out.println(p.getId() + " | " + p.getNom()+ " | " + p.getPrenom()); 
//			System.out.println("---------------------------");
//		}

		
//
		System.out.println("-----------  MENU  -----------");
		System.out.println("0 -  QUITTER");
		System.out.println("1 -  SE CONNECTER");
		System.out.println("2 -  S'INSCRIRE");
		System.out.println("choisir option: "); 
		int num = lireEntier();	
		
		while (num != 0) {
			if (num == 1) {
				connect(daoUtilisateur);
			}
			else if (num == 2) {
				inscriptionJoueur(daoUtilisateur);
			}	
			System.out.println("-----------  MENU  -----------");
			System.out.println("0 -  QUITTER");
			System.out.println("1 -  SE CONNECTER");
			System.out.println("2 -  S'INSCRIRE");
			System.out.println("choisir option: "); 
			num= lireEntier();
			
		}
	} 	
//	
//		
	public int connect(IDAOUtilisateur daoUtilisateur) {
		int i = 0;
		int a = 0;

		Scanner sc = new Scanner(System.in);	
			System.out.println("------------- Connexion ----------------");
			System.out.println("Username : ");
			String use = sc.next();
			System.out.println("Password : ");
			String pass = sc.next();
			i = connexion(use, pass);
		
		if (i == 1) {
			menuJoueur(daoUtilisateur);
			
		}
			
		else if (i == 2) {
			menuAdministrateur();
			
		}	
		return a;
	}
	
	public void inscriptionJoueur(IDAOUtilisateur daoUtilisateur) {
	
	
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
	
	}

	
	
	public void menuJoueur(IDAOUtilisateur daoUtilisateur) {
		
			System.out.println("--------  MENU JOUEUR  --------");
			System.out.println("0 -  QUITTER");
			System.out.println("1 -  NOUVELLE PARTIE");
			System.out.println("2 -  REJOINDRE UNE PARTIE");
			System.out.println("choisir option: "); 
			int num= lireEntier();

	} 
		
	
	public void menuAdministrateur() {
		System.out.println("--------  MENU ADMINISTRATEUR  --------");
		
		System.out.println("0 -  QUITTER");
		System.out.println("1 - AFFICHER PARTIES ");
		System.out.println("2 -  ");
		System.out.println("3 -  ");
		System.out.println("choisir option: "); 
		int num= lireEntier();
		
		
	
	}
	
	
	public int lireEntier() {
		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextInt();
		}

		catch (Exception ex) {
			return 0;
		}
	}
	
	public int connexion (String use, String pass) {
		int i = 0;

//		System.out.println(daoUtilisateur.connexionJoueur("AntoineL", "0000"));
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
		//SI daoUser.connecJoueur == null ==> potentiellement un admin
		//SI daoUser.connectAdmin == null ==> mauvais login
		
		
		
		
//		int i = 0;
//		Utilisateur unUser = new Utilisateur();
//		try {
//			System.out.println("Connexion de joueur en cours");
//			daoUtilisateur.connexionJoueur(username, password);
//			
//				System.out.println("Bienvenue : " + username);
//				return i = 1;
//		}
//		
//		catch (Exception e) {
//				try {
//					System.out.println("Connexion de administrateur en cours");
//					daoUtilisateur.connexionAdministrateur(username, password);
//					System.out.println("Bienvenue adm : " + unUser.getUsername());
//					return i = 2;	
//				}
//				
//				catch (Exception e2) {
//					System.out.println("Connexion échouée");
//					return i;	
//				}
//		}
	}
		
		
}

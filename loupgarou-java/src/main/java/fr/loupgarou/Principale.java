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
		
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
//	@Autowired
//	private ApplicationContext ctx;
	
	@Transactional
	public void  run (String[] args)   {
		
		System.out.println("-----------------------FIND BY UTILISATEUR ID------------------------");
//		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);
	
		for (Utilisateur p: (daoUtilisateur).findByUtilisateurId(25)) {
			System.out.println(p.getId() + " | " + p.getNom()+ " | " + p.getPrenom()); 
			System.out.println("---------------------------");
		}

	}
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
//		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL(emf);
//		System.out.println("-----------  MENU  -----------");
//		System.out.println("0 -  QUITTER");
//		System.out.println("1 -  SE CONNECTER");
//		System.out.println("2 -  S'INSCRIRE");
//		System.out.println("choisir option: "); 
//		int num = lireEntier();	
//		
//		while (num != 0) {
//			if (num == 1) {
//				connect(daoUtilisateur);
//			}
//			else if (num == 2) {
//				inscriptionJoueur(daoUtilisateur);
//			}	
//			System.out.println("-----------  MENU  -----------");
//			System.out.println("0 -  QUITTER");
//			System.out.println("1 -  SE CONNECTER");
//			System.out.println("2 -  S'INSCRIRE");
//			System.out.println("choisir option: "); 
//			num= lireEntier();
//			
//		}
//		emf.close();
//	} 	
//	
//		
//	public static int connect(IDAOUtilisateur daoUtilisateur) {
//		int i = 0;
//		int a = 0;
//
//		Scanner sc = new Scanner(System.in);	
//			System.out.println("------------- Connexion ----------------");
//			System.out.println("Username : ");
//			String use = sc.next();
//			System.out.println("Password : ");
//			String pass = sc.next();
//			i = daoUtilisateur.connexion(use, pass);
//		
//		if (i == 1) {
//			menuJoueur(daoUtilisateur);
//			
//		}
//			
//		else if (i == 2) {
//			menuAdministrateur();
//			
//		}	
//		return a;
//	}
//	
//	public static void inscriptionJoueur(IDAOUtilisateur daoUtilisateur) {
//	
//	
//	Utilisateur nouvelUtilisateur = new Joueur();
//	Scanner sc = new Scanner(System.in);
//	
//	
//	System.out.println("Saisir un Nom : ");
//	String a = sc.next();
//	nouvelUtilisateur.setNom(a);
//	
//	System.out.println("Saisir un Prénom : ");
//	String b = sc.next();
//	nouvelUtilisateur.setPrenom(b);
//	
//	System.out.println("Saisir un Username : ");
//	String c = sc.next();
//	nouvelUtilisateur.setUsername(c);
//	
//	System.out.println("Saisir un Password : ");
//	String d = sc.next();
//	nouvelUtilisateur.setPassword(d);
//	daoUtilisateur.save(nouvelUtilisateur);
//	
//	}
//
//	
//	
//	public static void menuJoueur(IDAOUtilisateur daoUtilisateur) {
//		
//			System.out.println("--------  MENU JOUEUR  --------");
//			System.out.println("0 -  QUITTER");
//			System.out.println("1 -  NOUVELLE PARTIE");
//			System.out.println("2 -  REJOINDRE UNE PARTIE");
//			System.out.println("choisir option: "); 
//			int num= lireEntier();
//
//	} 
//		
//	
//	public static void menuAdministrateur() {
//		System.out.println("--------  MENU ADMINISTRATEUR  --------");
//		
//		System.out.println("0 -  QUITTER");
//		System.out.println("1 - AFFICHER PARTIES ");
//		System.out.println("2 -  ");
//		System.out.println("3 -  ");
//		System.out.println("choisir option: "); 
//		int num= lireEntier();
//		
//		
//	
//	}
//	
//	
//	static int lireEntier() {
//		Scanner myScanner = new Scanner(System.in);
//
//		try {
//			return myScanner.nextInt();
//		}
//
//		catch (Exception ex) {
//			return 0;
//		}
//	}
		
		
}

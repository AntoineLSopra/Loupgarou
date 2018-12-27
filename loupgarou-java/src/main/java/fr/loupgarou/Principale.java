package fr.loupgarou;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exception.CountnotfoundException;
import fr.loupgarou.model.*;

import fr.loupgarou.dao.sql.*;
import fr.loupgarou.dao.sql.*;
import fr.loupgarou.idao.sql.*;

public class Principale {
		
	public static void main(String[] args) throws CountnotfoundException {
		connect();
//		System.out.println("-----------  MENU  -----------");
//		System.out.println("0 -  QUITTER");
//		System.out.println("1 -  SE CONNECTER");
//		System.out.println("2 -  S'INSCRIRE");
//		System.out.println("choisir option: "); int num = lireEntier();	
//		
//		while (num != 0) {
//			if (num == 1) {
//				connect();
//			}
//			else if (num == 2) {
//				inscriptionJoueur();
//			}	
//			System.out.println("-----------  MENU  -----------");
//			System.out.println("0 -  QUITTER");
//			System.out.println("1 -  SE CONNECTER");
//			System.out.println("2 -  S'INSCRIRE");
//			System.out.println("choisir option: "); 
//			num= lireEntier();
//			
//		}	
	} 	
	
		
	public static void connect() {
		int i = 0;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL(emf);
		Scanner sc = new Scanner(System.in);	
			System.out.println("------------- Connexion ----------------");
			System.out.println("Username : ");
			String use = sc.next();
			System.out.println("Password : ");
			String pass = sc.next();
			i = daoUtilisateur.connexion(use, pass);
		
		if (i == 1) {
			menuJoueur();
		}
			
		else if (i == 2) {
			menuAdministrateur();
		}	
		emf.close();
		
	}
	
//	public static void inscriptionJoueur() {
//	IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL();
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

	
	
	public static void menuJoueur() {
		System.out.println("--------  MENU JOUEUR  --------");
		
		
		
		
		
		
		
	} 
		
	public static void menuAdministrateur() {
		System.out.println("--------  MENU ADMINISTRATEUR  --------");
		
		
		
		
		
		
		
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
		
		
}

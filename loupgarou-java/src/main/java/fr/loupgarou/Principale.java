package fr.loupgarou;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import fr.loupgarou.model.*;

import fr.loupgarou.dao.sql.*;
import fr.loupgarou.dao.sql.*;
import fr.loupgarou.idao.sql.*;

public class Principale {
		
	public static void main(String[] args) {
		
		System.out.println("-----------  MENU  -----------");
		System.out.println("0 -  QUITTER");
		System.out.println("1 -  SE CONNECTER");
		System.out.println("2 -  S'INSCRIRE");
		System.out.println("choisir option: "); int num = lireEntier();	
		
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
	
		
	public static void connect() {
		
		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL();
		Scanner sc = new Scanner(System.in);
		int i = 0;	
			System.out.println("------------- Connexion ----------------");
			System.out.println("Username : ");
			String use = sc.next();
			System.out.println("Password : ");
			String pass = sc.next();
//			daoUtilisateur.connexion(use, pass);
		i = daoUtilisateur.connexion(use, pass);
			
		if (i == 1) {
			menuJoueur();
		}
			
		else if (i == 2) {
			menuAdministrateur();
		}	
		
		
	}
	
	
	public static void inscriptionJoueur() {
	IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL();
	
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

package fr.loupgarou;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import fr.loupgarou.*;
import fr.loupgarou.dao.*;
import fr.loupgarou.dao.sql.*;
import fr.loupgarou.model.*;


public class PrincipaleUtilisateur {
	

	public static void main(String[] args) {
		IDAOUtilisateur daoUtilisateur = new DaoUtilisateurSQL();
//		CONNEXION DE L'UTILISATEUR

		Scanner sc = new Scanner(System.in);

			System.out.println("------------- Connexion ----------------");
			System.out.println("Username : ");
			String use = sc.next();
			System.out.println("Password : ");
			String pass = sc.next();
			daoUtilisateur.connexion(use, pass);
			System.out.flush();
		
		
		
//////		CREER UN UTILISATEUR
//		Utilisateur nouvelUtilisateur = new Utilisateur();
//		Scanner sc = new Scanner(System.in);
//		
//		
//		System.out.println("Saisir un Nom : ");
//		String a = sc.next();
//		nouvelUtilisateur.setNom(a);
//		
//		System.out.println("Saisir un Prénom : ");
//		String b = sc.next();
//		nouvelUtilisateur.setPrenom(b);
//		
//		System.out.println("Saisir un Username : ");
//		String c = sc.next();
//		nouvelUtilisateur.setUsername(c);
//		
//		System.out.println("Saisir un Password : ");
//		String d = sc.next();
//		nouvelUtilisateur.setPassword(d);
//		daoUtilisateur.save(nouvelUtilisateur);
		
//		daoUtilisateur.deleteById(13);
		
		
////		MODIFIER UN UTILISATEUR
//		Utilisateur modifierUtilisateur = new Utilisateur();
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Saisir un Id : ");
//		int e = sc.nextInt();
//		modifierUtilisateur.setId(e);
//		
//		System.out.println("Saisir un Nom : ");
//		String a = sc.next();
//		modifierUtilisateur.setNom(a);
//		
//		System.out.println("Saisir un Prenom : ");
//		String b = sc.next();
//		modifierUtilisateur.setPrenom(b);
//		
//		System.out.println("Saisir un Username : ");
//		String c = sc.next();
//		modifierUtilisateur.setUsername(c);
//		
//		System.out.println("Saisir un Password : ");
//		String d = sc.next();
//		modifierUtilisateur.setPassword(d);
//		daoUtilisateur.save(modifierUtilisateur);
		
//		SUPPRIMER UN UTILISATEUR
//		daoUtilisateur.deleteById(13);
			
		
//		METHODE FINDBYID
//		int id = 1;
//		IDAOUtilisateur idUtilisateur = new DaoUtilisateurSQL();
//		Utilisateur monUtilisateuratrouver = idUtilisateur.findById(id);
//		
//		System.out.println("-------------" + id + "----------------");
//		System.out.println("Le nom = " + monUtilisateuratrouver.getNom());
//		System.out.println("Le username " + monUtilisateuratrouver.getUsername());

		
//		METHODE FINDALL
//		List<Utilisateur> lesUtilisateurs = daoUtilisateur.findAll();
//		for (Utilisateur u : lesUtilisateurs) {
//					System.out.println("-------------------------------");
//					System.out.println("Le nom = " + u.getNom());
//					System.out.println("Le username " + u.getUsername());
//		}
		
	}	
		
}

	
	//try {
	//	Connection myConnection = DriverManager.getConnection("jdbc:mysql://192.168.1.125:3306/loupgarou?serverTimezone=UTC", "root", "");
	//	System.out.println("Connexion réussie");
	//	}
	//	catch (SQLException e) {
	//		e.printStackTrace();
	//	System.out.println("Connexion échouée");
	//	}

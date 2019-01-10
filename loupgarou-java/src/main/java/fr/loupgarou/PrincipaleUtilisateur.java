package fr.loupgarou;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.loupgarou.*;
import fr.loupgarou.dao.*;
import fr.loupgarou.dao.sql.*;
import fr.loupgarou.idao.sql.IDAOUtilisateur;
import fr.loupgarou.model.*;


public class PrincipaleUtilisateur {
	

	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/////////////////   SQL  /////////////////////	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL(emf);
		
//		METHODE FINDBYID
//		int id = 5;
//		IDAOUtilisateur idUtilisateur = new DAOUtilisateurSQL();
//		Utilisateur monUtilisateuratrouver = idUtilisateur.findById(id);
//		
//		System.out.println("-------------" + id + "----------------");
//		System.out.println("Le nom = " + monUtilisateuratrouver.getNom());
//		System.out.println("Le prénom = " + monUtilisateuratrouver.getPrenom());
//		System.out.println("Le username = " + monUtilisateuratrouver.getUsername());

				
		
		
//		METHODE FINDALL
//		List<Utilisateur> lesUtilisateurs = daoUtilisateur.findAll();
//		for (Utilisateur u : lesUtilisateurs) {
//					System.out.println("-------------------------------");
//					System.out.println("Le nom = " + u.getNom());
//					System.out.println("Le username " + u.getUsername());
//		}
		
////		CREER UN UTILISATEUR
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
//		emf.close();
		
//		SUPPRIMER UTILISATEUR
//		daoUtilisateur.deleteById(22);
		
		
//		MODIFIER UN UTILISATEUR
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
		
		
		

		
	
	}	
		
}

package fr.loupgarou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.loupgarou.dao.sql.*;
import fr.loupgarou.idao.sql.*;
import fr.loupgarou.model.*;



public class PrincipalePersonnage {

	public static void main(String[] args) {
		
		
		

//		findAll(): AFFICHER PERSONNAGES
//		trouverTousPersonnages();	
		
//		findById(): TROUVER PERSONNAGE
//		trouverPersonnageParId();
		
//		save(): CREER UN NOUVEAU PERSONNAGE
//		sauvegarderPersonnage();			
		
//		deleteById(): SUPPRIMER PERSONNAGE
//		supprimerPersonnageParId();

		
	}
	
	public static void trouverTousPersonnages() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL(emf);
		
		List<Personnage> lesPersonnages = daoPersonnage.findAll();
		
		System.out.println("----  NOM DES PERSONNAGES  ----");
		
		for (Personnage p : lesPersonnages) {
		System.out.println(p.getId() + "-" + p.getLibelle() );
		emf.close();
		}
	}
	
	public static void trouverPersonnageParId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL(emf);
		Personnage lePersonnage = daoPersonnage.findById(1);
		System.out.println(lePersonnage.getLibelle());
		emf.close();
	}
	
	public static void sauvegarderPersonnage() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL(emf);
		Personnage monPerso= new Personnage();
		monPerso.setLibelle("Ogre");
		daoPersonnage.save(monPerso);
		emf.close();
	}
	
	public static void supprimerPersonnageParId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL(emf);
		daoPersonnage.deleteById(10);
		emf.close();
	}
}

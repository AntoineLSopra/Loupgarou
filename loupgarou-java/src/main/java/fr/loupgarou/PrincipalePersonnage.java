package fr.loupgarou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.loupgarou.dao.*;
import fr.loupgarou.dao.sql.DAOPersonnageSQL;
import fr.loupgarou.idao.sql.IDAOPersonnage;
import fr.loupgarou.model.*;



public class PrincipalePersonnage {

	public static void main(String[] args) {
		
//		findAll(): AFFICHER PERSONNAGES
		
//		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL();
//		
//		List<Personnage> lesPersonnages = daoPersonnage.findAll();
//		
//		System.out.println("----  NOM DES PERSONNAGES  ----");
//		
//		for (Personnage p : lesPersonnages) {
//			System.out.println(p.getId() + "-" + p.getLibelle() );
//		}
	
		
//		findById(): TROUVER PERSONNAGE
		
//		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL();
//		Personnage lePersonnage = daoPersonnage.findById(1);
//		System.out.println(lePersonnage.getLibelle());
		
		
//		save(): CREER UN NOUVEAU PERSONNAGE
		
//		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL();
//		Personnage monPerso= new Personnage();
//		monPerso.setLibelle("Ogre");
//		daoPersonnage.save(monPerso);
		
		
		
//		save(): MODIFIER UN PERSONNAGE
		
//		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL();
//		Personnage Loup = daoPersonnage.findById(1);
//		Loup.setLibelle("Loup_Garou");
//		daoPersonnage.save(Loup);
		
		
//		deleteById(): SUPPRIMER PERSONNAGE
		
//		IDAOPersonnage daoPersonnage = new DAOPersonnageSQL();
//		daoPersonnage.deleteById(10);
		
		
		
	}
}

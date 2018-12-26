//package fr.loupgarou.dao.sql;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.BreakIterator;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//import fr.loupgarou.model.*;
//import fr.loupgarou.dao.*;
//import fr.loupgarou.dao.sql.*;
//import fr.loupgarou.idao.sql.IDAOUtilisateur;
//
//
//public class DAOUtilisateurSQL extends DAOSQL implements IDAOUtilisateur {
//	
//	private EntityManager em;
//	
//	public DAOUtilisateurSQL(EntityManagerFactory emf) {
//		this.em = emf.createEntityManager();
//	}
//	
//	
//	
//	public int connexion(String username, String password) {
//		Utilisateur monUtilisateur = null;
//		PreparedStatement myStatement;
//		int i = 0;
//		try {
//			this.connect();
//			
//			myStatement = this.connection.prepareStatement("SELECT UTI_USERNAME, UTI_PASSWORD, JOU_BANNI FROM utilisateur u"
//					+ " INNER JOIN joueur j ON j.JOU_ID = u.UTI_ID " + 
//					"WHERE UTI_USERNAME=? AND UTI_PASSWORD= ? AND JOU_BANNI = 0;");
//			myStatement.setString(1, username);
//			myStatement.setString(2, password);
//			ResultSet myResult = myStatement.executeQuery();
//			if (myResult.next()) {
//				System.out.println("Bienvenue : " + username);
//				i = 1;
//				
//			}
//			else {
//				
//				myStatement = this.connection.prepareStatement("SELECT UTI_USERNAME, UTI_PASSWORD, ADM_ID FROM utilisateur u"
//					+	" INNER JOIN administrateur a ON a.ADM_ID = u.UTI_ID"
//					+	" WHERE UTI_USERNAME=? AND UTI_PASSWORD=? AND ADM_ID != 0");
//				myStatement.setString(1, username);
//				myStatement.setString(2, password);
//				ResultSet myResult2 = myStatement.executeQuery();
//				
//				if (myResult2.next()) {
//					System.out.println("Bienvenue adm : " + username);
//					i = 2;
//					
//				}
//				
//				else {
//				System.out.println("Connexion Impossible");
//				}
//			}
//			
//		}
//		
//			catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connexion échouée");
//			}
//		return i;
//			
//	}
//	
//	
//	public List<Utilisateur> findAll() {
//		List<Utilisateur> mesUtilisateurs = new ArrayList<Utilisateur>();
//		
//		try {
//			this.connect();
//			System.out.println("Connexion réussie");
//			Statement myStatement = this.connection.createStatement();
//			ResultSet myResult = myStatement.executeQuery("SELECT UTI_ID, UTI_NOM, UTI_PRENOM, UTI_USERNAME, UTI_PASSWORD from utilisateur;");
//			while (myResult.next()) {
//				Utilisateur u = this.map(myResult);				
//				mesUtilisateurs.add(u);			
//			}
//		}
//			catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connexion échouée");
//			}
//		return mesUtilisateurs;		
//	}
//	
//	public Utilisateur findById(int id) {
//		Utilisateur monUtilisateur = null;
////		Scanner sc = new Scanner(System.in);
////		System.out.println("Saisir un id de Produit : ");
////		int id = sc.nextInt();
//		try {
//			this.connect();
//			
//			PreparedStatement myStatement = this.connection
//					.prepareStatement("SELECT * FROM utilisateur WHERE UTI_ID = ?");
//			myStatement.setInt(1, id);
//			ResultSet myResult = myStatement.executeQuery();
//			if (myResult.next()) {
//				monUtilisateur = this.map(myResult);
//				
//			}
//		}
//			catch (SQLException e) {
//			System.out.println("Connexion échouée");
//			}
//		return monUtilisateur;
//	}
//	
//	public Utilisateur save( Utilisateur u) {
//		
//		try {
//			this.connect();
//			String myQuery = "";
//			String myQuery2 = "";
//			System.out.println("Connexion à la base réussie");
//			
//			
//			
//			if (u.getId() == 0) {
//				
//				if( u instanceof Joueur ) { // CREER UN JOUEUR 
//					
//					myQuery  = ("INSERT INTO utilisateur (UTI_NOM, UTI_PRENOM, UTI_USERNAME, UTI_PASSWORD) VALUES (?,?,?,?)");
//					myQuery2 = ("INSERT INTO joueur (JOU_ID, JOU_BANNI)  VALUES (LAST_INSERT_ID(), 0)");	
//				}
//					
//				else if( u instanceof Administrateur ) { // CREER UN ADMINISTRATEUR 
//					
//					myQuery  = ("INSERT INTO utilisateur (UTI_NOM, UTI_PRENOM, UTI_USERNAME, UTI_PASSWORD) VALUES (?,?,?,?)");
//					myQuery2 = ("INSERT INTO administrateur (ADM_ID)  VALUES (LAST_INSERT_ID())");
//				}				
//			}
//			
//			else {
//				myQuery = ("UPDATE utilisateur SET UTI_NOM = ?, UTI_PRENOM = ?, UTI_USERNAME = ?, UTI_PASSWORD = ? WHERE UTI_ID = ?");
//			
//			System.out.println("Utilisateur modifié");
//			}
//			
//			
//			PreparedStatement myStatement = this.connection.prepareStatement(myQuery);
//			PreparedStatement myStatement2 = this.connection.prepareStatement(myQuery2);
//			
//			myStatement.setString(1, u.getNom());
//			myStatement.setString(2, u.getPrenom());
//			myStatement.setString(3, u.getUsername());
//			myStatement.setString(4, u.getPassword());
//			
//			if(u.getId() > 0) {
//				myStatement.setInt(5, u.getId());
//			}
//			
//			myStatement.execute();
//			myStatement2.execute();
//			
//			
//			
//			
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connexion échouée");
//			}
//		
//		return u;
//	}
//	
//	public void deleteById(int id) {
//		Utilisateur monUtilisateur = null;
////		Scanner sc = new Scanner(System.in);
////		System.out.println("Saisir un id de Produit : ");
////		int id = sc.nextInt();
//		try {
//			this.connect();;
//			
//			PreparedStatement myStatement = this.connection
//					.prepareStatement("DELETE FROM utilisateur WHERE UTI_ID = ?");
//			myStatement.setInt(1, id);
//			myStatement.execute();
//			
//		}
//			catch (SQLException e) {
//			System.out.println("Connexion échouée");
//			}
//		
//	}
//	
//	public void delete(Utilisateur u) {
//		this.deleteById(u.getId());
//	}
//	
//
//}

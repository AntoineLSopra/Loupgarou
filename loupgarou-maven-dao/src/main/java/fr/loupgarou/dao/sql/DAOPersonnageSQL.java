package fr.loupgarou.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import fr.loupgarou.model.*;
import fr.loupgarou.dao.IDAOPersonnage;
import fr.loupgarou.dao.sql.*;

public class DAOPersonnageSQL extends DAOSQL implements IDAOPersonnage{
	
	
	
	public Personnage map(ResultSet result) throws SQLException {
		Personnage p = new Personnage();
		
		//ASSOCIER LES VALEURS DE LA DB A L'OBJET
		p.setId(result.getInt("PER_ID"));
		p.setLibelle(result.getString("PER_LIBELLE"));
				
		return p;
	}
	
	public List<Personnage> findAll() {
		
		List<Personnage> mesPersonnages = new ArrayList<Personnage>();
		
		try {
			this.connect();
			
			System.out.println("Connexion réussie");
			
			Statement myStatement = this.connection.createStatement();
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM personnage");

			while (myResult.next()) {
				Personnage p = this.map(myResult);
				
				//AJOUT DU PRODUIT DANS LA LISTE
				mesPersonnages.add(p);
				
			}
		}
		
		catch (SQLException e) {
			
			System.out.println("Connexion échouée");
			e.printStackTrace();
		}
		
		return mesPersonnages;
	}
	
	public Personnage findById(int id) {
		Personnage monPersonnage = null;
		
		try {
			this.connect();
			PreparedStatement myStatement = this.connection
					.prepareStatement("SELECT * FROM personnage WHERE PER_ID = ?");
			
			myStatement.setInt(1, id);
			ResultSet myResult = myStatement.executeQuery();

			if (myResult.next()) {
				monPersonnage = this.map(myResult);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return monPersonnage;
	}

	public Personnage save(Personnage p) {
		try {
			this.connect();
			String myQuery = "";
			
			if (p.getId() == 0) { //Ajout du personnage
				myQuery = "INSERT INTO personnage (PER_LIBELLE) VALUES (?)";
			}
			
			else { //Mise à jour du personnage
				myQuery = "UPDATE personnage SET PER_LIBELLE = ? WHERE PER_ID = ?";
			}
			
			PreparedStatement myStatement = this.connection.prepareStatement(myQuery);
			
			myStatement.setString(1, p.getLibelle());
			
			if (p.getId() > 0) {
				myStatement.setInt(2, p.getId());
			}
						
			myStatement.execute();
			
			System.out.println("Personnage sauvegardé");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public void deleteById(int id) {
		try {
			this.connect();
			PreparedStatement myStatement = this.connection
					.prepareStatement("DELETE FROM personnage WHERE PER_ID = ?");
			
			myStatement.setInt(1, id);
			myStatement.execute();
			System.out.println("Personnage supprimé");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Personnage p) {
		this.deleteById(p.getId());
	}

	
	
	
}

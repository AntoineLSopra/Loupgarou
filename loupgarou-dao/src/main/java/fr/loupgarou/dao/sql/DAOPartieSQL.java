package fr.loupgarou.dao.sql;

	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.loupgarou.model.*;

import fr.loupgarou.dao.sql.*;
import fr.loupgarou.idao.sql.IDAOPartie;


public class DAOPartieSQL extends DAOSQL implements IDAOPartie {
	
		public Partie map(ResultSet result) throws SQLException {
			Partie p = new Partie();
			
			//ASSOCIER LES VALEURS DE LA DB A L'OBJET
			p.setId(result.getInt("PAR_ID"));
						
					
			Histoire h = new Histoire();
			h.setId(result.getInt("PAR_HISTOIRE_ID"));
			p.setHistoire(h);
			
		
			Joueur j = new Joueur();
			j.setId(result.getInt("PAR_CAPITAINE_ID"));
			p.setCapitaine(j);
			
		
			return p;
		}
		
		public List<Partie> findAll() {
			
			List<Partie> mesParties = new ArrayList<Partie>();
			
			try {
				this.connect();
				
				System.out.println("Connexion réussie");
				
				Statement myStatement = this.connection.createStatement();
				ResultSet myResult = myStatement.executeQuery("SELECT * FROM partie");

				while (myResult.next()) {
					Partie p = this.map(myResult);
					
					//AJOUT DU PRODUIT DANS LA LISTE
					mesParties.add(p);
				}
			}
			
			catch (SQLException e) {
				
				System.out.println("Connexion échouée");
				e.printStackTrace();
			}
			
			return mesParties;
		}
		
		public Partie findById(int id) {
			Partie maPartie = null;
			
			try {
				this.connect();
				PreparedStatement myStatement = this.connection
						.prepareStatement("SELECT * FROM Partie WHERE PAR_ID = ?");
				
				myStatement.setInt(1, id);
				ResultSet myResult = myStatement.executeQuery();

				if (myResult.next()) {
					maPartie = this.map(myResult);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return maPartie;
		}

		public Partie save(Partie p) {
			try {
				this.connect();
				String myQuery = "";
				
				myQuery = "INSERT INTO partie (PAR_HISTOIRE_ID, PAR_CAPITAINE_ID) VALUES (?, ?)";
				
				
				PreparedStatement myStatement = this.connection.prepareStatement(myQuery);
				
				myStatement.setInt(1, p.getHistoire().getId());
				myStatement.setInt(2, p.getCapitaine().getId());
				
				
				if (p.getId() > 0) {
					myStatement.setInt(3, p.getId());
				}
							
				myStatement.execute();

				System.out.println("Partie sauvegardée");
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return p;
		}
		
		
		
		public Partie modify(Partie p) {
			try {
				this.connect();
				String myQuery = "";
			
				myQuery = "UPDATE partie SET PAR_CAPITAINE_ID  = ? WHERE PAR_ID = ?";
				
				
				PreparedStatement myStatement = this.connection.prepareStatement(myQuery);
				
				myStatement.setInt(1, p.getCapitaine().getId());
				
				
				if (p.getId() > 0) {
					myStatement.setInt(2, p.getId());
				}
						
				
				myStatement.execute();

				System.out.println("Partie modifiée");
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
						.prepareStatement("DELETE FROM partie WHERE PAR_ID = ?");
				
				myStatement.setInt(1, id);
				myStatement.execute();
				System.out.println("Partie supprimé");
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void delete(Partie p) {
			this.deleteById(p.getId());
		}

		
		
	

}

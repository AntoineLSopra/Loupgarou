package fr.loupgarou.dao.sql;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import fr.loupgarou.model.*;
import fr.loupgarou.idao.sql.IDAOUtilisateur;


public class DAOUtilisateurSQL extends DAOSQL implements IDAOUtilisateur {
	
	private EntityManager em;
	
	public DAOUtilisateurSQL(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}
	
	
//	A FAIRE
	public int connexion(String username, String password){
		int i = 0;
		try {
			System.out.println("Connexion de joueur en cours");
			TypedQuery<Joueur> myStatement;
			myStatement = em.createQuery("select j from Joueur j where j.username = :username and j.password = :password and j.banni = false", Joueur.class);
			myStatement.setParameter("username", username);
			myStatement.setParameter("password", password);
			Joueur myJoueur = myStatement.getSingleResult();
			
				System.out.println("Bienvenue : " + username);
				i = 1;
		}
		
		catch (Exception e) {
				try {
					e.printStackTrace();
					System.out.println("Connexion de administrateur en cours");
					TypedQuery<Administrateur> myStatement;
					myStatement = em.createQuery("select a from Administrateur a where a.username = :username and a.password = :password", Administrateur.class);
					myStatement.setParameter("username", username);
					myStatement.setParameter("password", password);
					Administrateur myAdmin = myStatement.getSingleResult();
					System.out.println("Bienvenue adm : " + username);
					i = 2;	
				}
				
				catch (Exception e2) {
					System.out.println("Connexion échouée");
					return i;	
				}
		}
//			return i;
//			if (myResult.next()) {
//				
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
		
		return i;
	}
	
	
	public List<Utilisateur> findAll() {
		return em
				.createQuery("select u from Utilisateur u", Utilisateur.class)
				.getResultList();		
	}
	
	public Utilisateur findById(int id) {
		return em.find(Utilisateur.class, id);
	}
	
	public Utilisateur save( Utilisateur entity) {
		
		//On démarre la transaction
				em.getTransaction().begin();
				
				if (entity.getId() == 0) {
					em.persist(entity);
				}
				
				else {
					entity = em.merge(entity);
				}
				
				//On commit la transaction
				em.getTransaction().commit();
				
				return entity;
	}
	
	public void deleteById(int id) {
		Utilisateur myUtilisateur = new Utilisateur();
		myUtilisateur.setId(id);
		this.delete(myUtilisateur);
		
	}
	
	public void delete(Utilisateur u) {
		this.deleteById(u.getId());
	}
	

}

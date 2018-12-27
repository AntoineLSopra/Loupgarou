package fr.loupgarou.dao.sql;

	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.loupgarou.model.*;
import fr.loupgarou.dao.sql.*;
import fr.loupgarou.idao.sql.IDAOPartie;


public class DAOPartieSQL extends DAOSQL implements IDAOPartie {
	
	
		private EntityManager em;
	
		public DAOPartieSQL(EntityManagerFactory emf) {
			this.em = emf.createEntityManager();
		}
			
		
		public List<Partie> findAll() {
			return em
					.createQuery("select p from Partie p", Partie.class)
					.getResultList();
		}
		
		
		public Partie findById(int id) {
			return em.find(Partie.class, id);	
		}
		
		public Partie save(Partie entity) {	
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
			
				Partie maPartie = new Partie();
				maPartie.setId(id);
				this.delete(maPartie);
		}
		
		
		public void delete(Partie entity) {
			em.remove(em.merge(entity));
		}

		
}

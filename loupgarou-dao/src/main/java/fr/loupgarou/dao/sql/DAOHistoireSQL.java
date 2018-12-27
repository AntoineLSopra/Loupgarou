package fr.loupgarou.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.loupgarou.idao.sql.IDAOHistoire;
import fr.loupgarou.model.Histoire;



public class DAOHistoireSQL extends DAOSQL implements IDAOHistoire  {
	private EntityManager em;
	
	public DAOHistoireSQL(EntityManagerFactory em1) {
		this.em = em1.createEntityManager();
	}
	
	public List<Histoire> findAll() {
		return em
				.createQuery("select h from Histoire h", Histoire.class)
				.getResultList();
	}
	
	public Histoire findById(int id) {
		return em.find(Histoire.class, id);
	}

	
	public Histoire save(Histoire entity) {
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

	
	public void delete(Histoire entity) {
		em.remove(em.merge(entity));
	}

	
	public void deleteById(int id) {
		Histoire myHistoire = new Histoire();
		myHistoire.setId(id);
		this.delete(myHistoire);
	}

}

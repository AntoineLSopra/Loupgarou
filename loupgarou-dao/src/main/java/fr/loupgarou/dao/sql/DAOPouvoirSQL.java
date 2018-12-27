package fr.loupgarou.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.loupgarou.idao.sql.IDAOPouvoir;
import fr.loupgarou.model.Pouvoir;
import fr.loupgarou.model.Pouvoir;

public class DAOPouvoirSQL extends DAOSQL implements IDAOPouvoir {
private EntityManager em;
	
	public DAOPouvoirSQL(EntityManagerFactory em5) {
		this.em = em5.createEntityManager();
	}
	
	public List<Pouvoir> findAll() {
		return em
				.createQuery("select h from Histoire h", Pouvoir.class)
				.getResultList();
	}
	
	public Pouvoir findById(int id) {
		return em.find(Pouvoir.class, id);
	}

	
	public Pouvoir save(Pouvoir entity) {
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

	
	public void delete(Pouvoir entity) {
		em.remove(em.merge(entity));
	}

	
	public void deleteById(int id) {
		Pouvoir myPouvoir = new Pouvoir();
		myPouvoir.setId(id);
		this.delete(myPouvoir);
	}

}
package fr.loupgarou.dao.sql;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.loupgarou.model.*;
import fr.loupgarou.idao.sql.IDAOPersonnage;

public class DAOPersonnageSQL extends DAOSQL implements IDAOPersonnage{
		
	
	private EntityManager em;
	
	public DAOPersonnageSQL(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}

	public List<Personnage> findAll() {
		
		return em
				.createQuery("select p from Personnage p", Personnage.class)
				.getResultList();
	}
	
	
	
	public Personnage findById(int id) {
		
		return em.find(Personnage.class, id);
	
	}

	
	
	public Personnage save(Personnage entity) {
		
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
		
		Personnage monPersonnage = new Personnage();
		monPersonnage.setId(id);
		this.delete(monPersonnage);
		
		
	}
	
	public void delete(Personnage entity) {
		em.remove(em.merge(entity));
	}

	
	
	
}

package fr.loupgarou.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.loupgarou.idao.sql.IDAOParticipation;
import fr.loupgarou.model.Participation;
import fr.loupgarou.model.Participation;

public class DAOParticipationSQL extends DAOSQL implements IDAOParticipation  {
	private EntityManager em;
	
	public DAOParticipationSQL(EntityManagerFactory em3) {
		this.em = em3.createEntityManager();
	}
	
	public List<Participation> findAll() {
		return em
				.createQuery("select ptn from Participation ptn", Participation.class)
				.getResultList();
	}

	
	public Participation findById(int id) {
		return em.find(Participation.class, id);
	}

	
	public Participation save(Participation entity) {
		//On démarre la transaction
		em.getTransaction().begin();
		
		if (entity.getJoueur().getId() == 0) {
			em.persist(entity);
		}
		
		else {
			entity = em.merge(entity);
		}
		
		//On commit la transaction
		em.getTransaction().commit();
		
		return entity;
	}

	
	public void delete(Participation entity) {
		em.remove(em.merge(entity));
	}

	
	public void deleteById(int id) {
		Participation myParticipation = new Participation();
		myParticipation.getJoueur().setId(id);
		this.delete(myParticipation);
	}

}

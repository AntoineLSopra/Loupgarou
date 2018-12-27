package fr.loupgarou.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.loupgarou.idao.sql.IDAOMessage;
import fr.loupgarou.model.Histoire;
import fr.loupgarou.model.Message;

public class DAOMessageSQL extends DAOSQL implements IDAOMessage {
	private EntityManager em;
	
	public DAOMessageSQL(EntityManagerFactory em2) {
		this.em = em2.createEntityManager();
	}
	
	public List<Message> findAll() {
		return em
				.createQuery("select m from Message m", Message.class)
				.getResultList();
	}

	
	public Message findById(int id) {
		return em.find(Message.class, id);
	}

	
	public Message save(Message entity) {
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

	
	public void delete(Message entity) {
		em.remove(em.merge(entity));
	}

	
	public void deleteById(int id) {
		Message myMessage = new Message();
		myMessage.setId(id);
		this.delete(myMessage);
	}

}

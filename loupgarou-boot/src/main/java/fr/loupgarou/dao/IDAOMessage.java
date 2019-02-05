package fr.loupgarou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.loupgarou.model.Message;
import fr.loupgarou.model.Participation;

public interface IDAOMessage extends JpaRepository<Message, Integer> {

	List<Message> findByPartieId(int id);

}

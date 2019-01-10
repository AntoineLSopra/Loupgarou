package fr.loupgarou.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.loupgarou.model.Message;

public interface IDAOMessage extends JpaRepository<Message, Integer> {

}

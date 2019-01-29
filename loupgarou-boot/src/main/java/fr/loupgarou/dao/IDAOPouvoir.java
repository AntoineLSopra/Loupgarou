package fr.loupgarou.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.loupgarou.model.Pouvoir;

public interface IDAOPouvoir extends JpaRepository<Pouvoir, Integer> {

}

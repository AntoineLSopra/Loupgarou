package fr.loupgarou.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.loupgarou.model.Partie;


public interface IDAOPartie extends JpaRepository<Partie, Integer> {

	

	
}

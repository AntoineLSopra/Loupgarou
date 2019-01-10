package fr.loupgarou.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.loupgarou.model.Personnage;

public interface IDAOPersonnage extends JpaRepository<Personnage, Integer>{

	
	
}

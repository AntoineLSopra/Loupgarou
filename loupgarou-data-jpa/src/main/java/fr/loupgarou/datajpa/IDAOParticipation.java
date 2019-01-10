package fr.loupgarou.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.loupgarou.model.Participation;

public interface IDAOParticipation extends JpaRepository<Participation, Integer>{

	
}

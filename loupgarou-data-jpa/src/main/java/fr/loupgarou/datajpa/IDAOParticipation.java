package fr.loupgarou.datajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.loupgarou.model.Participation;
import fr.loupgarou.model.Partie;
import fr.loupgarou.model.Personnage;

public interface IDAOParticipation extends JpaRepository<Participation, Integer>{


	public List<Participation> findByPartieId(int id);

}

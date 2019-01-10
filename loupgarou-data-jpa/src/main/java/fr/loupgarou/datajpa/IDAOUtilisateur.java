package fr.loupgarou.datajpa;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import fr.loupgarou.model.*;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{
	@Query("")
	public int connexion(String use, String pass);

	
	@Query("select u from Utilisateur u where u.id = :id")
	public List<Utilisateur> findByUtilisateurId(@Param ("id") int id);
	
	
}


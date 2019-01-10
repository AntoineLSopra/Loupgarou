package fr.loupgarou.datajpa;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.loupgarou.model.*;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{
	@Query("")
	public int connexion(String use, String pass);

}


package fr.loupgarou.datajpa;



import org.springframework.data.jpa.repository.JpaRepository;

import fr.loupgarou.model.*;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{

	public int connexion(String use, String pass);

}


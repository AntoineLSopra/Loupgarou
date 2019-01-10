package fr.loupgarou.datajpa;



import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.loupgarou.model.*;


public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{
	
	@Query("select u from Utilisateur u where u.id = :id")
	public List<Utilisateur> findByUtilisateurId(@Param ("id") int id);

	@Query("select j from Joueur j where j.username = :username and j.password = :password and j.banni = false")
    public Joueur connexionJoueur(@Param ("username") String use, @Param ("password") String pass);
	
    @Query("select a from Administrateur a where a.username = :username and a.password = :password")
    public Administrateur connexionAdministrateur(@Param ("username") String use, @Param ("password") String pass);
}


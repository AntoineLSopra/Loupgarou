package fr.loupgarou.datajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.loupgarou.model.Personnage;
import fr.loupgarou.model.Pouvoir;

public interface IDAOPersonnage extends JpaRepository<Personnage, Integer>{
	@Query("select distinct p from Personnage p left join fetch p.pouvoirs")
	public List<Personnage> trouveravecPouvoirs ();
}

package fr.loupgarou.dao;

import fr.loupgarou.model.Partie;
import fr.loupgarou.model.Personnage;

public interface IDAOPartie extends IDAO<Partie> {

	
	public Partie modify(Partie p);
	
}
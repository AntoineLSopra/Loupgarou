package fr.loupgarou.dao;

import fr.loupgarou.dao.*;
import fr.loupgarou.dao.sql.ExceptionUtilisateurInconnu;
import fr.loupgarou.model.*;

public interface IDAOUtilisateur extends IDAO<Utilisateur>{
	public Utilisateur connexion (String username, String password); // throws ExceptionUtilisateurInconnu

}




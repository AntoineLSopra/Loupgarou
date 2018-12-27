package fr.loupgarou.idao.sql;


import exception.CountnotfoundException;
import fr.loupgarou.model.*;

public interface IDAOUtilisateur extends IDAO<Utilisateur>{

	public int connexion(String use, String pass);

}


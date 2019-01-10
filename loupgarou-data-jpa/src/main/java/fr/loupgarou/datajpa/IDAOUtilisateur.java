package fr.loupgarou.datajpa;



import fr.loupgarou.model.*;

public interface IDAOUtilisateur extends IDAO<Utilisateur>{

	public int connexion(String use, String pass);

}


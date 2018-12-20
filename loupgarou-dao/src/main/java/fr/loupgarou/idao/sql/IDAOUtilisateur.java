package fr.loupgarou.idao.sql;

import fr.loupgarou.dao.sql.*;
import fr.loupgarou.model.*;

public interface IDAOUtilisateur extends IDAO<Utilisateur>{

	public int connexion(String use, String pass);

}


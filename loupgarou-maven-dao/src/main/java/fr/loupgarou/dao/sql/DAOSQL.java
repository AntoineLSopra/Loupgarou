package fr.loupgarou.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.loupgarou.dao.IDAO;

public class DAOSQL{
	protected Connection connection;

	
	public void connect() throws SQLException {
		if(this.connection == null) {
			this.connection = DriverManager
					.getConnection("jdbc:mysql://192.168.1.125:3306/loupgarou?serverTimezone=UTC", "root", "");

		}
	}
}

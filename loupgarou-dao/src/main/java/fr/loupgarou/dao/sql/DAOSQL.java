package fr.loupgarou.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOSQL {

	protected Connection connection = null;
	
	public void connect() throws SQLException {
		if (this.connection == null) {
			this.connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/loupgarou?serverTimezone=UTC", "root", "");
		}
	}
	
	
}

package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import util.ConnectionBD;

public abstract class AbstractDao {
	private ConnectionBD connect;
	
	public AbstractDao() throws ClassNotFoundException, IOException, SQLException {
		this.connect = new ConnectionBD();
	}
	
	public Statement getStatement() throws SQLException {
		return this.connect.getConnection().createStatement();
	}
}

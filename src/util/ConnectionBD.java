package util;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionBD {
	
	private static String driverClass;
	private static String url;
	private static String login;
	private static String password;
	private static Connection connect;
	
	
	public ConnectionBD() throws IOException, ClassNotFoundException, SQLException {
		setProperties();
		setConnection();
	}

	private void setConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverClass);
		connect = DriverManager.getConnection(url, login,password);
		//System.out.println("Connexion avec succès");
	}

	private void setProperties() throws IOException {
		
		FileInputStream in = new FileInputStream("C:\\Users\\az\\eclipse-workspace\\TP_IW\\Resources\\Res.properties");
		Properties propFile = new Properties();
		propFile.load(in);
		driverClass = propFile.getProperty("jdbc.driverClass");
		url = propFile.getProperty("jdbc.url");
		login = propFile.getProperty("jdbc.login");
		password = propFile.getProperty("jdbc.password");
	
	}
	public Connection getConnection() {
		return connect;
	}
}

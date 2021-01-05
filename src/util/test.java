package util;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		ConnectionBD bd = new ConnectionBD();
		Statement myStmt = bd.getConnection().createStatement();
		ResultSet myRs = myStmt.executeQuery("Select * from demowamp");
		
		while(myRs.next()) {
			System.out.println(myRs.getString("titre"));
		}
		System.out.println("test1 validée");

	}

}

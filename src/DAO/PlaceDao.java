package DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Place;

public class PlaceDao extends AbstractDao {
	
	public PlaceDao() throws ClassNotFoundException, IOException, SQLException
	{
		super();
	}
	public int createPlace(Place p) throws SQLException {
		Statement myStmt = getStatement();
		String sql = "INSERT INTO place(name) values ('"+ p.getName() + "');";
		myStmt.executeUpdate(sql);
		
		return p.getId();
	}
	public Place findPlaceById(Long id) throws SQLException {
		Statement myStmt = getStatement();
		String sql = "Select * from place WHERE id =" + id +";";
		ResultSet myRs = myStmt.executeQuery(sql);
		if (myRs.next()) {
			return new Place(Math.toIntExact(id),myRs.getString("name"));
		}else {
			return new Place(Math.toIntExact(id),"this id not exist");
		}
		
		
	}
	public boolean updatePlace(Place p) throws SQLException {
		Statement myStmt = getStatement();
		String sql = "UPDATE place SET name = '"+ p.getName() +"' WHERE id = " + p.getId() +";";
		try {
			myStmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean removePlace(int id) throws SQLException {
		Statement myStmt = getStatement();
		String sql = "delete from place where id = " +id +";";
		try {
			int rowsAffected = myStmt.executeUpdate(sql);
			System.out.println("Rows affected : " + rowsAffected);
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}

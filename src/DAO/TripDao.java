package DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.Trip;

public class TripDao extends AbstractDao{
	
	private PlaceDao placeDao;
	
	public TripDao(PlaceDao placeDao) throws ClassNotFoundException, IOException, SQLException {
		super();
		this.placeDao = placeDao;
	}
	
	public int createTrip(Trip t) throws SQLException {
		Statement myStmt = getStatement();
		String sql = "INSERT INTO trip(depart_id,dest_id,price) VALUES(" +t.getDeparture().getId() +","+ t.getDestination().getId()+","+ t.getPrice()+" );";
		try {
			myStmt.executeUpdate(sql);
			return t.getId();
		} catch (SQLException e) {
			return -1;
		}
		
	}
	
	public Trip findTripById(Long id) throws SQLException {
		Statement myStmt = getStatement();
		String sql = "Select * from trip WHERE id =" + id +";";
		try {
			ResultSet myRs = myStmt.executeQuery(sql);
			myRs.next();
			return new Trip(Math.toIntExact(id), placeDao.findPlaceById( Long.parseLong(myRs.getString(2))), placeDao.findPlaceById( Long.parseLong(myRs.getString(3))), Double.parseDouble(myRs.getString(4)));
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		}
		
		
	}
	
	public boolean removeTrip(int id) throws SQLException{
		Statement myStmt = getStatement();
		String sql = "delete from trip where id = " +id +";";
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

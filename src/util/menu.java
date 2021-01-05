package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import DAO.PlaceDao;
import DAO.TripDao;
import model.Place;
import model.Trip;

public class menu {
	private static PlaceDao placeDao;
	private static TripDao tripDao;
	
	public menu(PlaceDao placeDao, TripDao tripDao) {
		this.placeDao = placeDao;
		this.tripDao = tripDao;
	}
	
	public void showMenu() throws IOException {
		FileInputStream in = new FileInputStream("C:\\Users\\az\\eclipse-workspace\\TP_IW\\Resources\\Res.properties");
		Properties propFile = new Properties();
		propFile.load(in);
		String menu1 = "Welcome aboard!\n" +
                "\n" +
                "What do you want to do?\n" +
                "1 - Add a place\n" +
                "2 - Find a place\n" +
                "3 - Edit a place\n" +
                "4 - Remove a place\n" +
                "5 - Add a trip\n" +
                "6 - Find a trip\n" +
                "7 - Remove a trip\n" +
                "8 - Quit";
		String menu2 ="Bienvenue à bord!\n" +
                "\n" +
                "Qu'est-ce que vous voulez faire?\n" +
                "1 - Ajouter un lieu\n" +
                "2 - Trouver un lieu\n" +
                "3 - Modifier un lieu\n" +
                "4 - Supprimer un lieu\n" +
                "5 - Ajouter un voyage\n" +
                "6 - Trouver un voyage\n" +
                "7 - Supprimer un voyage\n" +
                "8 - Quitter";
		System.out.println("\n");
		if (propFile.getProperty("lang").equals("fr")) {
			System.out.println(menu2);
		}else {
			System.out.println(menu1);
		}
       
	}
	
	
	public String scanInput() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public void answerMenu(int input) throws SQLException {
		switch (input) {
		case 1: {
			System.out.println("Name :");
			Place add = new Place(scanInput());
			System.out.println("Place added with the ID = "+ placeDao.createPlace(add));
			//System.out.println("\n<SUCCESS> " + add.getName() + " [ID-" + add.getId() +"]");
            break;
			
		}
		case 2: {
			System.out.println("\nenter the id of the place you are looking for :");
//			if (placeDao.findPlaceById(Long.parseLong(scanInput())).getName().contains("not")) {
//				System.out.println(placeDao.findPlaceById(Long.parseLong(scanInput())).getName());
//			}else {
				System.out.println("The name of the place is :"+placeDao.findPlaceById(Long.parseLong(scanInput())).getName());
//			}
			break;
		}
		case 3: {
			System.out.println("\nenter the id of the place that you want to update");
			int updateId = Integer.parseInt(scanInput());
			System.out.println("enter the name :");
			String updateName = scanInput();
			Place updatePlace = new Place(updateId,updateName);
			placeDao.updatePlace(updatePlace);
			System.out.println("The new name of the place is "+ updatePlace.getName()+" Where id = " + updatePlace.getId());
			break;
		}
		case 4: {
			System.out.println("\nenter the id of the place that you want to delete");
			int deleteId = Integer.parseInt(scanInput());
			if (placeDao.removePlace(deleteId)) {
				System.out.println("Delete complete.");
			}else {
				System.out.println("Delete not complite");
			}
			break;
		}
		case 5:{
			System.out.println("\nEnter the departure");
			Place depart = new Place(scanInput());
			placeDao.createPlace(depart);
			System.out.println("\nEnter the destination");
			Place dest = new Place(scanInput());
			placeDao.createPlace(depart);
			System.out.println("\nEnter the price");
			double price = Double.parseDouble(scanInput());
			Trip trip = new Trip(depart, dest, price);
			tripDao.createTrip(trip);
			System.out.println(trip.toString());
			break;
		}
		case 6:{
			System.out.println("\nenter the id of the trip you are looking for :");
			System.out.println("The trip is :"+tripDao.findTripById(Long.parseLong(scanInput())));
			break;
		}
		case 7:{
			System.out.println("\nenter the id of the trip that you want to delete");
			int deleteId = Integer.parseInt(scanInput());
			if (tripDao.removeTrip(deleteId)) {
				System.out.println("Delete complete.");
			}else {
				System.out.println("Delete not complite");
			}
			
			break;
		}
		
		case 8: {
			System.exit(0);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}
}

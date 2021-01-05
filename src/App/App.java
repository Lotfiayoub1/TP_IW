package App;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.PlaceDao;
import DAO.TripDao;
import util.menu;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		PlaceDao PDAO = new PlaceDao();
		TripDao TDAO = new TripDao(PDAO);
		int reponse = 0;
		Scanner sc = new Scanner(System.in);
		menu m = new menu(PDAO, TDAO);
		do {
			m.showMenu();
			reponse = sc.nextInt();
			m.answerMenu(reponse);
		} while (reponse != 8);

	}

}

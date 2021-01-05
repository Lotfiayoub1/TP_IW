package model;

public class Trip {
	private static int curid = 0;
	private int id;
	private Place departure;
	private Place destination;
	private double price;
	
	public Trip(Place departure, Place destination, double price) {
		this.id=++curid;
		this.departure = departure;
		this.destination = destination;
		this.price = price;
	}
	public Trip(int id,Place departure, Place destination, double price) {
		this.id=id;
		this.departure = departure;
		this.destination = destination;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Place getDeparture() {
		return departure;
	}
	public void setDeparture(Place departure) {
		this.departure = departure;
	}
	public Place getDestination() {
		return destination;
	}
	public void setDestination(Place destination) {
		this.destination = destination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
        return "Trip{" +
                "id=" + id +
                ":" + departure +
                ">>>>>>>" + destination +
                " price=" + price +
                "MAD}";
    }
}

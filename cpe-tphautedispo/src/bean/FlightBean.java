package bean;

import java.io.Serializable;
import java.util.Date;

//import modules.datastore.DatastoreUserToolbox;

import com.google.appengine.api.datastore.Key;
import objects.Flight;


public class FlightBean implements Serializable {

	private static final long serialVersionUID = 3990847190742761461L;
	
	private Flight _flight = null;
	
	public FlightBean () {};
	
	public Flight getFlight() {
		if (this._flight == null) {
			this._flight = new Flight();
		}
		
		return _flight;
	}
		
	public void setFlight(Flight flight) {
		this._flight = flight;
	}

	public void setKey ( Key key )
	{
		this.getFlight().setKey(key);
	}
	public Key getKey ( ) {
		return this.getFlight().getKey();
	}
	public void setFlightNumber ( String flightNumber ) {
		this.getFlight().setFlightNumber(flightNumber);
	}
	public String getFlightNumber() {
		return this.getFlight().getFlightNumber();
	}
	public String getDepartureAirport ( ) {
		return this.getFlight().getDepartureAirport();
	}
	public void setDepartureAirport ( String departureAirport ) {
		this.getFlight().setDepartureAirport(departureAirport);
	}
	public Date getDepartureTime() {
		return this.getFlight().getDepartureTime();
	}

	public void setDepartureTime(Date DepartureTime) {
		this.getFlight().setDepartureTime(DepartureTime);
	}

	public String getArrivalAirport ( ) {
		return this.getFlight().getArrivalAirport();
	}
	
	public void setArrivalAirport ( String ArrivalAirport ) {
		this.getFlight().setArrivalAirport(ArrivalAirport);
	}

	public Date getArrivalTime() {
		return this.getFlight().getArrivalTime();
	}

	public void setArrivalTime(Date DepartureTime) {
		this.getFlight().setArrivalTime(DepartureTime);
	}
	
	public Integer getAvailableSeats() {
		return getFlight().getAvailableSeats();
	}
	
	public void setAvailableSeats( Integer availableSeats) {
		getFlight().setAvailableSeats(availableSeats);
	}
	
	public Double getSeatPrice() {
		return getFlight().getSeatPrice();
	}
	
	public void setSeatPrice( Double seatPrice) {
		getFlight().setSeatPrice(seatPrice);
	}
}

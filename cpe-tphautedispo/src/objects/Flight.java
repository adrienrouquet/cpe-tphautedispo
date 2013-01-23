package objects;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Flight implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Key _key								= null;
	private String _flightNumber			= "";
	private String _departureAirport		= "";
	private Date _departureTime	= null;
	private String _arrivalAirport			= "";
	private Date _arrivalTime			= null;
	private Integer _availableSeats		= 0;
	private Double _seatPrice				= 0.0;
	
	public Flight()
	{
	}
	
	public Flight(Entity entity)
	{
		_flightNumber			= (String) entity.getProperty("flightNumber");
		_departureAirport 	= (String) entity.getProperty("departureAirport");
		_departureTime		= (Date) entity.getProperty("departureTime");
		_arrivalAirport 			= (String) entity.getProperty("arrivalAirport");
		_arrivalTime				= (Date) entity.getProperty("arrivalTime");
		_availableSeats	= Integer.parseInt((entity.getProperty("availableSeats").toString()));
		_seatPrice					= (Double) entity.getProperty("seatPrice");
		_key = entity.getKey();
	}
	
	public Flight(String flightNumber, String departureAirport, Date departureTime, String arrivalAirport, Date arrivalTime, Integer availableSeats, Double seatPrice) {

		_flightNumber			= flightNumber;
		_departureAirport 	= departureAirport;
		_departureTime		= departureTime;
		_arrivalAirport 			= arrivalAirport;
		_arrivalTime				= arrivalTime;
		_availableSeats			= availableSeats;
		_seatPrice					= seatPrice;
	}
	
		public String getFlightNumber() {
		return _flightNumber;
	}

	public void setFlightNumber(String _flightNumber) {
		this._flightNumber = _flightNumber;
	}

	public String getDepartureAirport() {
		return _departureAirport;
	}

	public void setDepartureAirport(String _departureAirport) {
		this._departureAirport = _departureAirport;
	}

	public Date getDepartureTime() {
		return _departureTime;
	}

	public void setDepartureTime(Date _departureTime) {
		this._departureTime = _departureTime;
	}

	public String getArrivalAirport() {
		return _arrivalAirport;
	}

	public void setArrivalAirport(String _arrivalAirport) {
		this._arrivalAirport = _arrivalAirport;
	}

	public Date getArrivalTime() {
		return _arrivalTime;
	}

	public void setArrivalTime(Date _arrivalTime) {
		this._arrivalTime = _arrivalTime;
	}

	public Integer getAvailableSeats() {
		return _availableSeats;
	}

	public void setAvailableSeats(Integer _availableSeats) {
		this._availableSeats = _availableSeats;
	}

	public Double getSeatPrice() {
		return _seatPrice;
	}

	public void setSeatPrice(Double _seatPrice) {
		this._seatPrice = _seatPrice;
	}

		public Key getKey() {
		return _key;
	}
	
	public void setKey(Key key) {
		this._key = key;
	}
	
	public String getKeyAsString() {
		return KeyFactory.keyToString(_key);
	}
	
	public String getDepartureTimeFormated() {
		return DateFormat.getDateInstance().format(_departureTime);
	}
	
	public String getArrivalTimeFormated() {
		return DateFormat.getDateInstance().format(_arrivalTime);
	}
}

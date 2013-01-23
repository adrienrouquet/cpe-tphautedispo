package objects;

import java.io.Serializable;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.repackaged.com.google.api.client.util.DateTime;

public class Flight implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Key _key								= null;
	private String _flightNumber			= "";
	private String _departureAirport		= "";
	private DateTime _departureTime	= null;
	private String _arrivalAirport			= "";
	private DateTime _arrivalTime			= null;
	private Integer _availableSeats		= 0;
	private Double _seatPrice				= 0.0;
	
	public Flight()
	{
	}
	
	public Flight(Entity entity)
	{
		_flightNumber			= (String) entity.getProperty("flightNumber");
		_departureAirport 	= (String) entity.getProperty("departureAirport");
		_departureTime		= (DateTime) entity.getProperty("departureTime");
		_arrivalAirport 			= (String) entity.getProperty("arrivalAirport");
		_arrivalTime				= (DateTime) entity.getProperty("arrivalTime");
		_availableSeats			= (Integer) entity.getProperty("availableSeats");
		_seatPrice					= (Double) entity.getProperty("seatPrice");
	}
	
	public Flight(String flightNumber, String departureAirport, DateTime departureTime, String arrivalAirport, DateTime arrivalTime, Integer availableSeats, Double seatPrice) {

		_flightNumber			= (String) entity.getProperty("flightNumber");
		_departureAirport 	= (String) entity.getProperty("departureAirport");
		_departureTime		= (DateTime) entity.getProperty("departureTime");
		_arrivalAirport 			= (String) entity.getProperty("arrivalAirport");
		_arrivalTime				= (DateTime) entity.getProperty("arrivalTime");
		_availableSeats			= (Integer) entity.getProperty("availableSeats");
		_seatPrice					= (Double) entity.getProperty("seatPrice");
	}
	
	public Flight(String firstName, String lastName, Integer yearOfBirth, String email, String login) {
		
		_firstName 		= firstName;
		_lastName 		= lastName;
		_yearOfBirth 	= yearOfBirth;
		_email 				= email;
		_login				= login;
		_rightTypeId		= 3;
		_isConnected	= false;
	}
	
	
	
	public String getName() {
		return _firstName + " " + _lastName;
	}
	
	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		this._firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		this._lastName = lastName;
	}

	public Integer getYearOfBirth() {
		return _yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this._yearOfBirth = yearOfBirth;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		this._email = email;
	}

	public String getLogin() {
		return _login;
	}

	public void setLogin(String login) {
		this._login = login;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}
	
	public Integer getRightTypeId() {
		return _rightTypeId;
	}

	public void setRightTypeId(Integer rightTypeId) {
		this._rightTypeId = rightTypeId;
	}
	
	public Key getKey() {
		return _key;
	}
	
	public void setKey(Key key) {
		this._key = key;
	}
	
	public void connect()
	{
		this._isConnected = true;
	}
	
	public void disconnect()
	{
		this._isConnected = false;
	}

	public Boolean isConnected()
	{
		return _isConnected;
	}
	
	public Boolean isAdmin()
	{
		if(_rightTypeId == 1)
			return true;
		return false;
	}
	
}

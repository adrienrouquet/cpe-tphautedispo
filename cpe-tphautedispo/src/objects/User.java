package objects;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Key _key							= null;
	private String _firstName 			= "";
	private String _lastName 			= "";
	private Integer _yearOfBirth 		= 0;
	private String _email 					= "";
	private String _login 					= "";
	private String _password 			= "";
	private Date _creationDate			= null;
	private Integer _rightTypeId		= 0;
	private Boolean _isConnected 	= false;
	
	
	public User()
	{
	}
	
	public User(Entity entity)
	{
		_firstName 		= (String) entity.getProperty("firstName");
		_lastName 		= (String) entity.getProperty("lastName");
		_yearOfBirth 	= Integer.parseInt(entity.getProperty("yearOfBirth").toString());
		_email 				= (String) entity.getProperty("email");
		_login				= (String) entity.getProperty("login");
		_password 		= (String) entity.getProperty("password");
		_creationDate	= (Date) entity.getProperty("creationDate");
		_rightTypeId		= Integer.parseInt(entity.getProperty("rightTypeId").toString());
		_key					= entity.getKey();
		_isConnected	= false;
	}
	
	public User(String firstName, String lastName, Integer yearOfBirth, String email, String login, String password) {
	
		_firstName 		= firstName;
		_lastName 		= lastName;
		_yearOfBirth 	= yearOfBirth;
		_email 				= email;
		_login				= login;
		_password 		= password;
		_rightTypeId		= 3;
		_isConnected	= false;
	}
	
	public User(String firstName, String lastName, Integer yearOfBirth, String email, String login) {
		
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
	
	public String getCreationDateFormatted() {
		return DateFormat.getDateInstance().format(_creationDate);
	}
	
	public Date getCreationDate() {
		return _creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this._creationDate = creationDate;
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

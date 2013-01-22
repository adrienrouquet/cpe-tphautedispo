package objects;

import com.google.appengine.api.datastore.Entity;

public class User {
	
	private String _firstName 			= "";
	private String _lastName 			= "";
	private Integer _yearOfBirth 		= 0;
	private String _email 					= "";
	private String _login 					= "";
	private String _password 			= "";
	private Integer _rightTypeId		= 0;
	private Boolean _isConnected 	= false;
	private Entity _entity 					= null;
	
	public User(String firstName, String lastName, Integer yearOfBirth, String email, String login, String password) {
	
		_firstName 		= firstName;
		_lastName 		= lastName;
		_yearOfBirth 	= yearOfBirth;
		_email 				= email;
		_login				= login;
		_password 		= password;
		_rightTypeId		= 3;
		
		this.setEntity();	
	}
	
	public User(String firstName, String lastName, Integer yearOfBirth, String email, String login) {
		
		_firstName 		= firstName;
		_lastName 		= lastName;
		_yearOfBirth 	= yearOfBirth;
		_email 				= email;
		_login				= login;
		_rightTypeId		= 3;
		
		this.setEntity();
		
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
	
	public void setEntity()
	{
		_entity = new Entity("User");
		_entity.setProperty("firstName", _firstName);
		_entity.setProperty("lastName", _lastName);
		_entity.setProperty("yearOfBirth", _yearOfBirth);
		_entity.setProperty("login", _login);
		if(_password.equals(""))
			_password = RandomGenerator.generateRandomPassword(8);
		_entity.setProperty("password", _password);
	}
	
	public Entity getEntity()
	{
		return _entity;
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

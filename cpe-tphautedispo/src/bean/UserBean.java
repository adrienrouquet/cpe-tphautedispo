package bean;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;
import objects.User;


public class UserBean implements Serializable {

	private static final long serialVersionUID = 3990847190742761461L;
	
	private User _user = null;
	
	public UserBean () {};
	
	public User getUser() {
		if (this._user == null) {
			this._user = new User();
		}
		
		return _user;
	}
		
	public void setUser(User user) {
		this._user = user;
	}

	public void setKey ( Key key )
	{
		this.getUser().setKey(key);
	}
	public Key getKey ( ) {
		return this.getUser().getKey();
	}
	public void setLogin ( String login ) {
		this.getUser().setLogin(login);
	}
	public String getLogin ( ) {
		return this.getUser().getLogin();
	}
	public String getEmail ( ) {
		return this.getUser().getEmail();
	}
	public void setEmail ( String email ) {
		this.getUser().setEmail(email);
	}
	public String getFirstName() {
		return this.getUser().getFirstName();
	}

	public void setFirstName(String firstName) {
		this.getUser().setFirstName(firstName);
	}

	public String getLastName() {
		return this.getUser().getLastName();
	}

	public void setLastName(String lastName) {
		this.getUser().setLastName(lastName);
	}

	public String getName() {
		return getUser().getName();
	}
	
	public void connect() {
		this.getUser().connect();
	}
	public void disconnect() {
		this.getUser().disconnect();
	}
	public boolean isConnected () {
		return this.getUser().isConnected();
	}
}

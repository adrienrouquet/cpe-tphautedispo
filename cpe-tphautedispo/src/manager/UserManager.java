package manager;

import java.io.Serializable;
import java.util.ArrayList;
import com.google.appengine.api.datastore.Key;

import objects.User;
import modules.datastore.*;
import modules.email.EmailUserToolbox;

/**
 * AppCore UserManager
 */
public abstract class UserManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DatastoreUserToolbox _dsut = new DatastoreUserToolbox();
	private static EmailUserToolbox _eut = new EmailUserToolbox();
	
	public UserManager(){
	};
	
	public static Boolean checkCredentials(String login, String password) {
		return _dsut.checkCredentials(login, password);
	}
	
	public static User getUserFromCredentials(String login, String password)
	{
		return _dsut.getUserFromCredentials(login, password);
	}

	public static void addUser(String firstName, String lastName, Integer yearOfBirth, String email, String login, String password)
	{
		User user = new User(firstName, lastName, yearOfBirth, email, login, password);
		_dsut.putUserToDatastore(user);
		_eut.sendSubscriptionConfirmation(user);
	}
	
	public static String userExists(String email, String login)
	{
		
		return _dsut.userExists(email, login);
	}
	
	public static ArrayList<User> getUsers() {
		return _dsut.getUsers();
	}
	
	public static void deleteUser(Key key)
	{
		_dsut.removeEntityFromDatastore(key);
	}
}

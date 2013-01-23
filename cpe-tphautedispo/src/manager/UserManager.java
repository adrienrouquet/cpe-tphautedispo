package manager;

import java.util.ArrayList;
import java.util.HashMap;

import objects.User;
import modules.datastore.*;

/**
 * AppCore UserManager
 */
public abstract class UserManager {

	private static DatastoreUserToolbox _dsut = new DatastoreUserToolbox();

	public UserManager(){};
	
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
	}
	
	public static String userExists(String email, String login)
	{
		return _dsut.userExists(email, login);
	}
	
//	public static ArrayList<User> getUsers()
//	{
//		return _dsut.getEntityFromCredentials();
//	}
//	
//	public static int getIdFromLogin(String login)
//	{
//		return _dbut.getIdFromLogin(login);
//	}
//	
//	public static void setUsersConnected(HashMap<Integer, User> _usersConnected) {
//		UserManager._usersConnected = _usersConnected;
//	}
//
//	public static HashMap<Integer, User> getUsersConnected() {
//		return _usersConnected;
//	}
//
//	public static User getUserConnected(String login) {
//		return _usersConnected.get(UserManager.getIdFromLogin(login));
//	}
//	
//	public static User getUserConnected(Integer id) {
//		return _usersConnected.get(id);
//	}
//	
//	public static void addUserConnected(User user) {
//		System.out.println("User"+ user.getId() + "("+ user.getName() +") is connected");
//		_usersConnected.put(user.getId(),user);
//		
//		UserManager.updateContactsStatus(user);
//	}
//	
//	public static void delUserConnected(User user) {
//		System.out.println("User"+ user.getId() + "("+ user.getName() +") is disconnected");
//		_usersConnected.remove(user.getId());
//		
//		UserManager.updateContactsStatus(user);
//	}
//	
//	private static void updateContactsStatus (User user) {
//		for (User contact : user.getContacts()) {
//			User connectedContact = UserManager.getUserConnected(contact.getId());
//			if(connectedContact != null)
//			{
//				for (Websocket WS : connectedContact.getWebsockets()) {
//						WS.emit("updateContactStatus", user.getLogin(), user.getLastLoginDateFormated());
//				}
//			}
//		}
//	}
//	

//	public static User getUser(int id) {
//		return _dbut.getUser(id);
//	}
//	
//	public static User getUser(String login) {
//		return _dbut.getUser(login);
//	}
//	
//	
//	
//	public static String userExists(String email, String login) {
//		return _dbut.userExists(email,phone,login);
//	}
//	
//	public static void addUser(String firstName,String lastName,String email,String phone,String login,String password) {
//		_dbut.addUser(firstName,lastName,email,phone,login,password);
//	}
	
}

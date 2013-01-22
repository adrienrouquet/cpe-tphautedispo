package modules.datastore;

import objects.User;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class DatastoreUserToolbox extends DatastoreToolbox{

	public User getUserFromCredentials(String login, String password)
	{
		Query q = new Query("User");
		q.setFilter(new Query.FilterPredicate("login", Query.FilterOperator.EQUAL,login));
		q.setFilter(new Query.FilterPredicate("password", Query.FilterOperator.EQUAL,password));
		
		PreparedQuery pq = datastore.prepare(q);
		
		for(Entity rs : pq.asIterable()){
			return new User(rs);
		}
		return null;
	}
	
	public boolean checkCredentials(String login, String password)
	{
		boolean valid = false;
		
		if (getUserFromCredentials(login, password) != null)
		{
			valid = true;
		}		
		return valid;
	}
	
	public void putUserToDatastore(User user)
	{
		Entity userEntity = null;
		
		if(user.getKey() != null)
			userEntity = new Entity("User",user.getKey());
		else
			userEntity = new Entity("User");
		userEntity.setProperty("firstName", user.getFirstName());
		userEntity.setProperty("lastName", user.getLastName());
		userEntity.setProperty("yearOfBirth", user.getYearOfBirth());
		userEntity.setProperty("email", user.getEmail());
		userEntity.setProperty("login", user.getLogin());
		userEntity.setProperty("password", user.getPassword());
		userEntity.setProperty("rightTypeId", user.getRightTypeId());
	}

}

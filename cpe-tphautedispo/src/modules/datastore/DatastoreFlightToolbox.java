package modules.datastore;

import objects.User;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class DatastoreFlightToolbox extends DatastoreToolbox{

	public DatastoreFlightToolbox(){
		System.out.println("Entering DatastoreFlightToolbox constructor");
	}
	public User getFlightFromFlightNumber(String flightNumber){
		Query q = new Query("Flight");
		q.setFilter(new Query.FilterPredicate("flightNumber", Query.FilterOperator.EQUAL,flightNumber));
		
		PreparedQuery pq = datastore.prepare(q);
		
		for(Entity rs : pq.asIterable()){
			return new Flight(rs);
		}
		return null;
	}
	public Flight getFlightFromKey(Key key)
	{
		return new Flight(getEntityFromKey(key));
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
		datastore.put(userEntity);
	}

}

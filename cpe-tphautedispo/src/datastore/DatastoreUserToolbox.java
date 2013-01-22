package datastore;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class DatastoreUserToolbox extends DatastoreHandler{

	public Entity getEntityFromCredentials(String login, String password)
	{
		Query q = new Query("User");
		q.setFilter(new Query.FilterPredicate("login", Query.FilterOperator.EQUAL,login));
		q.setFilter(new Query.FilterPredicate("password", Query.FilterOperator.EQUAL,password));
		
		PreparedQuery pq = datastore.prepare(q);
		
		for(Entity rs : pq.asIterable()){
			return rs;
		}
		return null;
	}

}

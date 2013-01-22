package modules.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;

public class DatastoreHandler {
	DatastoreService datastore = null;
	
	public DatastoreHandler()
	{
		datastore = DatastoreServiceFactory.getDatastoreService();
	}
	
	public void putEntityToDatastore(Entity entity)
	{
		datastore.put(entity);
	}
	
	public Entity getEntityFromKey(Key key) throws EntityNotFoundException
	{
		return datastore.get(key);
	}
	
	public void removeEntityFromDatastore(Key key)
	{
		datastore.delete(key);
	}
	
}
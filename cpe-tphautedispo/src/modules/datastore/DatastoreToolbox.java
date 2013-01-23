package modules.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;

public class DatastoreToolbox {
	DatastoreService datastore = null;
	
	public DatastoreToolbox()
	{
		System.out.println("Entering DatastoreToolbox constructor");
		datastore = DatastoreServiceFactory.getDatastoreService();
		
	}
	
	public void putEntityToDatastore(Entity entity)
	{
		datastore.put(entity);
	}
	
	public Entity getEntityFromKey(Key key)
	{
		Entity entity = null;
		
		try
		{
			entity = datastore.get(key);
		}
		catch (EntityNotFoundException e)
		{
			System.err.println("Error in getEntityFromKey: " + e.getMessage());
		}
		
		return entity;
	}
	
	public void removeEntityFromDatastore(Key key)
	{
		datastore.delete(key);
	}
	
}
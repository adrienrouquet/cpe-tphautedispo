package manager;


import modules.datastore.DatastoreFlightToolbox;
import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;

import objects.Flight;

public abstract class FlightManager {
	
	private static DatastoreFlightToolbox _dftb = new DatastoreFlightToolbox();
	
	public static ArrayList<Flight> getFlights() {
		return _dftb.getFlights();
	}
	
	public static void deleteFlight(Key key)
	{
		_dftb.removeEntityFromDatastore(key);
	}
}

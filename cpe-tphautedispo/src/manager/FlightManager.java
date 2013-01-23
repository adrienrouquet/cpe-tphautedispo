package manager;


import modules.datastore.DatastoreFlightToolbox;

import java.io.Serializable;
import java.util.ArrayList;
import objects.Flight;

public abstract class FlightManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static DatastoreFlightToolbox _dftb = new DatastoreFlightToolbox();
	
	public static ArrayList<Flight> getFlights() {
		return _dftb.getFlights();
	}
}

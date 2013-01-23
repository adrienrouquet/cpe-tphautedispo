package manager;


import modules.datastore.DatastoreFlightToolbox;
import java.util.ArrayList;
import objects.Flight;

public abstract class FlightManager {
	
	private static DatastoreFlightToolbox _dftb = new DatastoreFlightToolbox();
	
	public static ArrayList<Flight> getFlights() {
		return _dftb.getFlights();
	}
}

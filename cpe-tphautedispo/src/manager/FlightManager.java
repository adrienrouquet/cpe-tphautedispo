package manager;


import modules.datastore.DatastoreFlightToolbox;

import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import objects.Flight;
import objects.User;

public abstract class FlightManager implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static DatastoreFlightToolbox _dftb = new DatastoreFlightToolbox();
	
	public static ArrayList<Flight> getFlights() {
		return _dftb.getFlights();
	}
	
	public static String TimeFormatted(Date date)
	{
		return new SimpleDateFormat("MM/dd/yyyy 'at' HH:mm").format(date);
	}
	
	public static void deleteFlight(Key key)
	{
		_dftb.removeEntityFromDatastore(key);
	}
	
	public static void addFlight(Flight flight)
	{
		_dftb.putFlightToDatastore(flight);
	}
}

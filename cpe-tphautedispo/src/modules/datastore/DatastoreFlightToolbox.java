package modules.datastore;

import objects.Flight;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class DatastoreFlightToolbox extends DatastoreToolbox{

	public DatastoreFlightToolbox(){
		System.out.println("Entering DatastoreFlightToolbox constructor");
	}
	public Flight getFlightFromFlightNumber(String flightNumber){
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
	
	public void putFlightToDatastore(Flight flight)
	{
		Entity flightEntity = null;
		
		if(flight.getKey() != null)
			flightEntity = new Entity("Flight",flight.getKey());
		else
			flightEntity = new Entity("Flight");
		flightEntity.setProperty("flightNumber", flight.getFlightNumber());
		flightEntity.setProperty("departureAirport", flight.getDepartureAirport());
		flightEntity.setProperty("departureTime", flight.getDepartureTime());
		flightEntity.setProperty("arrivalAirport", flight.getArrivalAirport());
		flightEntity.setProperty("arrivalTime", flight.getArrivalTime());
		flightEntity.setProperty("availableSeats", flight.getAvailableSeats());
		flightEntity.setProperty("seatPrice", flight.getSeatPrice());
		datastore.put(flightEntity);
	}

}

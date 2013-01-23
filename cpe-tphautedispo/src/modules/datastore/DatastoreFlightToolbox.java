package modules.datastore;

import java.util.ArrayList;

import objects.Flight;
import objects.User;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
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
	
	public ArrayList<Flight> getFlights()
	{
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		FetchOptions fetchoptions = FetchOptions.Builder.withLimit(Integer.MAX_VALUE);
		
		Query q = new Query("Flight");
		PreparedQuery pq = datastore.prepare(q);
		for(Entity rs : pq.asIterable()){
			flights.add(new Flight(rs));
		}
		return flights;		
	}

	public ArrayList<Flight> getFlights(String departureAirport, String arrivalAirport)
	{
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		Query q = new Query("Flight");
		q.setFilter(new Query.FilterPredicate("departureAirport", Query.FilterOperator.EQUAL,departureAirport));
		q.setFilter(new Query.FilterPredicate("arrivalAirport", Query.FilterOperator.EQUAL,arrivalAirport));
		
		PreparedQuery pq = datastore.prepare(q);
		
		for(Entity rs : pq.asIterable()){
			flights.add(new Flight(rs));
		}
		return flights;		
	}
}

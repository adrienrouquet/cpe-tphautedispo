package install;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Flight;
import objects.User;

import modules.datastore.DatastoreFlightToolbox;
import modules.datastore.DatastoreUserToolbox;
import modules.email.EmailUserToolbox;

public class DefaultConf  extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DefaultConf() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException
	{
		System.out.println("DefaultConf: Entering doGet");
		DatastoreUserToolbox dsut = new DatastoreUserToolbox();
		DatastoreFlightToolbox dsft = new DatastoreFlightToolbox();
		
		for (User user : dsut.getUsers()) {
			System.out.println("DEL USER: " + user.getName());
			dsut.removeEntityFromDatastore(user.getKey());
		}
		for (Flight flight : dsft.getFlights()) {
			System.out.println("DEL FLIGHT: " + flight.getFlightNumber());
			dsut.removeEntityFromDatastore(flight.getKey());
		}
		
		User admin = new User("admin", "istrator", 2000, "admin@souple-airlines.com", "admin", "password");
		admin.setRightTypeId(1);
		dsut.putUserToDatastore(new User("loic", "ortola", 1989, "ortola.loic@gmail.com","loic","loic"));
		dsut.putUserToDatastore(new User("adrien", "rouquet", 1987, "adrien.rouquet@gmail.com","adrien","rouquet"));
		dsut.putUserToDatastore(new User("henri", "lahoud", 1987, "lahoud.henri@gmail.com","henri","henri"));
		dsut.putUserToDatastore(admin);
		
		dsft.putFlightToDatastore(new Flight("12", "Lyon", new Date(), "Lyon", new Date(), 12, 12000.12));
		dsft.putFlightToDatastore(new Flight("13", "Paris", new Date(), "Store", new Date(), 12, 12000.12));
		dsft.putFlightToDatastore(new Flight("14", "Los Angeles", new Date(), "Le Malzieu-Ville", new Date(), 12, 12000.12));
		
		EmailUserToolbox eut = new EmailUserToolbox();
		eut.setEmailFrom("ortola.loic@gmail.com");
		eut.sendSubscriptionConfirmation(new User("admin", "istrator", 2000, "ortola.loic@gmail.com", "admin", "password"));
	}

}

package install;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.User;

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
		User admin = new User("admin", "istrator", 2000, "admin@souple-airlines.com", "admin", "password");
		admin.setRightTypeId(1);
		dsut.putUserToDatastore(new User("loic", "ortola", 1989, "ortola.loic@gmail.com","loic","loic"));
		dsut.putUserToDatastore(new User("adrien", "rouquet", 1987, "adrien.rouquet@gmail.com","adrien","rouquet"));
		dsut.putUserToDatastore(new User("henri", "lahoud", 1987, "lahoud.henri@gmail.com","henri","henri"));
		dsut.putUserToDatastore(admin);
		
		EmailUserToolbox eut = new EmailUserToolbox();
		eut.setEmailFrom("ortola.loic@gmail.com");
		eut.sendSubscriptionConfirmation(new User("admin", "istrator", 2000, "ortola.loic@gmail.com", "admin", "password"));
	}

}

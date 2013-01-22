package modules.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHandler {
	
	private String emailFrom = "";
	private String emailFromDescr = "";
	private String emailTo = "";
	private String emailToDescr = "";
	private String emailSubject = "";
	private String emailBody = "";
	
	
	public EmailHandler() {
		emailFrom = "test@gmail.com";
		emailFromDescr = "Test App";
	}
		
	public void Send()
	{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props);
		
		 try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(emailFrom, emailFromDescr));
			
			msg.addRecipient(Message.RecipientType.TO,	new InternetAddress(emailTo, emailToDescr));
			msg.setSubject(emailSubject);
			msg.setText(emailBody);
			Transport.send(msg);
 
	    }catch (AddressException e1) {
	         // ...
	    }catch (MessagingException e2) {
	         // ...
	    }catch (UnsupportedEncodingException e3) {
			// TODO Auto-generated catch block
		}	
	}
	
	
}

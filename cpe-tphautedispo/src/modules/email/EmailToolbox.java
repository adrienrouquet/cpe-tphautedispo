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

public class EmailToolbox {
	
	protected String _emailFrom 			= "";
	protected String _emailFromDescr 	= "";
	protected String _emailTo 				= "";
	protected String _emailToDescr 		= "";
	protected String _emailSubject 		= "";
	protected String _emailBody 			= "";
	
	public EmailToolbox() {
		_emailFrom = "ortola.loic@gmail.com";
		_emailFromDescr = "Test App";
	}
	
	public String getEmailFrom() {
		return _emailFrom;
	}

	public void setEmailFrom(String _emailFrom) {
		this._emailFrom = _emailFrom;
	}

	public String getEmailFromDescr() {
		return _emailFromDescr;
	}

	public void setEmailFromDescr(String _emailFromDescr) {
		this._emailFromDescr = _emailFromDescr;
	}

	public String getEmailTo() {
		return _emailTo;
	}

	public void setEmailTo(String _emailTo) {
		this._emailTo = _emailTo;
	}

	public String getEmailToDescr() {
		return _emailToDescr;
	}

	public void setEmailToDescr(String _emailToDescr) {
		this._emailToDescr = _emailToDescr;
	}

	public String getEmailSubject() {
		return _emailSubject;
	}

	public void setEmailSubject(String _emailSubject) {
		this._emailSubject = _emailSubject;
	}

	public String getEmailBody() {
		return _emailBody;
	}

	public void setEmailBody(String _emailBody) {
		this._emailBody = _emailBody;
	}
		
	public void send()
	{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props);
		
		 try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(_emailFrom, _emailFromDescr));
			
			msg.addRecipient(Message.RecipientType.TO,	new InternetAddress(_emailTo, _emailToDescr));
			msg.setSubject(_emailSubject);
			msg.setText(_emailBody);
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

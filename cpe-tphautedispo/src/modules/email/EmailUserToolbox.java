package modules.email;

import objects.User;

public class EmailUserToolbox extends EmailToolbox{
	
	public void sendSubscriptionConfirmation(User user)
	{
		_emailFromDescr 	= "Souple Airlines";
		_emailTo				= user.getEmail();
		_emailToDescr		= user.getName();
		_emailSubject		= "Thank you for your subscription";
		_emailBody			= "Hi, and thanks for creating your account on Souple Airlines.\n\n You are now ready to use our services.\nYour password is: " + user.getPassword() + "\nPlease do not lose it.";
		send();
	}
	public void sendNewPassword(User user)
	{
		_emailFromDescr 	= "Souple Airlines";
		_emailTo				= user.getEmail();
		_emailToDescr		= user.getName();
		_emailSubject		= "Password change request";
		_emailBody			= "Your new password is: " + user.getPassword() + "\nPlease do not lose it.";
		send();
	}
}

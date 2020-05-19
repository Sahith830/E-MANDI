package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnamePwdValidation 
{
	private Pattern pattern;
	private Matcher matcher1, matcher2;
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
													
	
	public boolean checkUserDetails(String email, String password, String confirmPassword, String mobile) 
	{
		if(validEmail(email) && validPassword(password,confirmPassword) && validMobile(mobile))
		{
		    return true;
		}
	    return false;
	}
	
	private boolean validEmail(String email) 
	{
		 String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		 return email.matches(regex);
	}
	
	private boolean validPassword(String password, String confirmPassword) 
	{
		 pattern = Pattern.compile(PASSWORD_PATTERN);
		 if(password.equals(confirmPassword)) 
		 {
			 matcher1 = pattern.matcher(password);
			 matcher2 = pattern.matcher(confirmPassword);
			 return (matcher2.matches() && matcher1.matches());
		 }
		return false;
	}
	private boolean validMobile(String mobile)
	{
		String regex = "(0/91)?[7-9][0-9]{9}";
		return mobile.matches(regex);
	}
}

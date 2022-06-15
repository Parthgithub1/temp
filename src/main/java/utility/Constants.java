package utility;

import java.util.Properties;

public class Constants {
	static String userDirectoryPath = System.getProperty("user.dir");
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();
	
	public static final String IMAGEFOLDER = userDirectoryPath + "/src/test/resources/Images/image.png";
	public static final String ENTERCODEFORTWOFACTORAUTHENTICATION = "5555";
	public static final String CONTINUEBUTTON = "Continue";
	public static final String PASSWORD = property.getProperty("password");
	public static final String ENVIRONMENT = "environment";
	public static final String CHANGEPASSWORD = property.getProperty("changePassword");
	public static final String LASTNAMESOLEPROPPASS = "SolePropPass";
	public static final String NUMBEROFATTEMPTSVALIDATIONMESSAGE = "more attempts before the account becomes locked";
}
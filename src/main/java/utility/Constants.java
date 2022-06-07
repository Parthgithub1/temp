package utility;

import java.util.Properties;

public class Constants {
	static String userDirectoryPath = System.getProperty("user.dir");
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();
	
	public static final String IMAGEFOLDER = userDirectoryPath + "/src/test/resources/Images/image.png";
	public static final String ENTERCODEFORTWOFACTORAUTHENTICATION = "5555";
	public static final String CONTINUEBUTOON = "Continue";
	public static final String PASSWORD = property.getProperty("password");
	public static final String ENVIRONMENT = "environment";
}
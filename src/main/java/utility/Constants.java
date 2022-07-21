package utility;

import java.util.Properties;

public class Constants {
	static String userDirectoryPath = System.getProperty("user.dir");
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.initProp();

	public static final String IMAGEFOLDER = userDirectoryPath + "/src/test/resources/Images/image.png";
	public static final String ENTERCODEFORTWOFACTORAUTHENTICATION = "5555";
	public static final String ENTERWRONGCODEFORVALIDATIONOFTWOFACTORAUTHENTICATION = "2018";
	public static final String CONTINUEBUTTON = "Continue";
	public static final String ENVIRONMENT = "environment";
	public static final String NUMBEROFATTEMPTSVALIDATIONMESSAGE = "more attempts before the account becomes locked";
	public static final String MAILINATORDOTCOM = "@mailinator.com";
	public static final String DOUBLECLICK = "DoubleClick";
	public static final String RECEIVABLE = "Receivable";
	public static final String PAYABLE = "Payable";	
	public static final String EMAIL = "Email";	
	public static final String BUSINESSNMAME = "BusinessName";	
	public static final String CONTACTNAME = "Contact name";	
}
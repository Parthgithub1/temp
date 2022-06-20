package utility;

import java.util.Properties;

public class Constants {
	static String userDirectoryPath = System.getProperty("user.dir");
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();
	
	public static final String IMAGEFOLDER = userDirectoryPath + "/src/test/resources/Images/image.png";
	public static final String ENTERCODEFORTWOFACTORAUTHENTICATION = "5555";
	public static final String ENTERWRONGCODEFORVALIDATIONOFTWOFACTORAUTHENTICATION = "2018";
	public static final String CONTINUEBUTTON = "Continue";
	public static final String ENVIRONMENT = "environment";
	public static final String LASTNAMESOLEPROPPASS = "SolePropPass";
	public static final String NUMBEROFATTEMPTSVALIDATIONMESSAGE = "more attempts before the account becomes locked";
	public static final String ADDBILLPAYNOTIFICATION = "It is on its way to";
	public static final String ADDBILLNOTIFICATIONONDASHBOARD = "sent an invoice for";
	public static final String BACKSPACE = "backspace";
	public static final String TAB = "tab";
	public static final String ADDBILLMESSAGEDETAILS = "This is the add bill details.";
	public static final String MAILINATORDOTCOM = "@mailinator.com";
	public static final String ADDBILLINVOICENUMBER = "1001";
	public static final String HOPSCOTCHAUTOMATIONDOTCOM = "@hopscotchautomation.com";
	public static final String SEARCHFORNEWBUSINES = "Search for new business";
	public static final String CUSTOMERFIRSTNAME = "Donald";
	public static final String CUSTOMERLASTNAME = "Trump";
	public static final String RESETYOURPASSWORD = "Reset your password";
	public static final String DOUBLECLICK = "DoubleClick";
	public static final String BUSINESSADDRESS = "55 Fruit Street";
	public static final String BUSINESSTAXID = "444559999";
	public static final String ADDBENEFICIALFIRSTNAME = "jack";
	public static final String ADDBENEFICIALLASTNAME = "denial";
	public static final String ADDBENEFICIALDATEOFBIRTH = "01012008";
	public static final String VERIFICATIONISCOMPLETE = "Verification is complete";
	public static final String VERIFICATIONISPENDING = "Verification is pending";
	public static final String SOLEPROPRIETORSHIPDATEOFBIRTH = "01012001";
	public static final String REGISTRATIONABOUTYOURCOMPANY = "This textarea contains value about company";
	public static final String REGISTRATIONWEBSITE = "https://www.google.com/";
	public static final String REGISTRATIONCITY = "lakesville";
	public static final String REGISTRATIONYEARFOUNDED = "2022";
	public static final String REGISTRATIONFIRSTNAME = "Ronald";
	public static final String REGISTRATIONBUSINESSNAME = "The Ronald Reagan";
}
package utility;

import org.apache.log4j.Logger;

public class Log {
	private static Logger log = Logger.getLogger(Log.class.getName());//

	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite
	static String lineseparator = "****************************************************************************************";

	public static void startTestCase(String testcasename) {

		log.info(lineseparator);

		log.info("$$$$$$$$$$$$$$$$$$$$$  Start of   " + testcasename + "     $$$$$$$$$$$$$$$$$$$$$$$$$");

		log.info(lineseparator);

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String testcasename) {

		log.info(lineseparator);

		log.info("XXXXXXXXXXXXXXXXXXXXXXX    End of      " + testcasename + "             XXXXXXXXXXXXXXXXXXXXXX");

		log.info(lineseparator);

	}

	// Need to create these methods, so that they can be called

	public static void info(Object message) {

		log.info(message);

	}

	public static void warn(Object message) {

		log.warn(message);

	}

	public static void error(String message) {

		log.error(message);

	}

	public static void fatal(String message) {

		log.fatal(message);

	}

	public static void debug(String message) {

		log.debug(message);

	}

}

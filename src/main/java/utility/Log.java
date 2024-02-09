package utility;

import org.apache.logging.log4j.*;

public class Log {
	private static Logger logging = LogManager.getLogger();

	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite
	static String lineseparator = "****************************************************************************************";

	public static void startTestCase(String testcasename) {

		logging.info(lineseparator);

		logging.info("$$$$$$$$$$$$$$$$$$$$$  Start of   " + testcasename + "     $$$$$$$$$$$$$$$$$$$$$$$$$");

		logging.info(lineseparator);

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String testcasename) {

		logging.info(lineseparator);

		logging.info("XXXXXXXXXXXXXXXXXXXXXXX    End of      " + testcasename + "             XXXXXXXXXXXXXXXXXXXXXX");

		logging.info(lineseparator);

	}

	// Need to create these methods, so that they can be called

	public static void info(Object message) {

		logging.info(message);

	}

	public static void warn(Object message) {

		logging.warn(message);

	}

	public static void error(String message) {

		logging.error(message);

	}

	public static void fatal(String message) {

		logging.fatal(message);

	}

	public static void debug(String message) {

		logging.debug(message);

	}

}

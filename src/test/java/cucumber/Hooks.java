package cucumber;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.AfterAll;
import utility.Driverhelper;
import utility.Environmenthelper;
import utility.Eventhelper;
import utility.Log;

public class Hooks {

	Driverhelper driverhelper = new Driverhelper();
	WebDriver driver;
	public static final String ENVIRONMENT = "environment";
	public static final String BROWSER = "browser";
	public static final String HEADLESS = "headless";

	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark;
	public static ExtentTest parenttest;
	public static ExtentTest childtest;
 
	public static String browserName;
	public static String browserVersion;
		
	
	@BeforeAll
	public static void setupExtent() {
		spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "Extentreport" + File.separator + "index.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("OS Name", System.getProperty("os.name"));
		extent.setSystemInfo("OS Version", System.getProperty("os.version"));
		extent.setSystemInfo("Environment",System.getProperty(ENVIRONMENT));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("Automation Report");
		spark.config().setTheme(Theme.STANDARD);
	}

	@Before
	public void setup(Scenario scenario) throws Exception {
		String[] test = scenario.getUri().toString().split("/");
		String[] longFeatureName = test[test.length - 1].split("\\.");
		parenttest = extent.createTest(longFeatureName[0]).assignCategory("Smoke");
		childtest = parenttest.createNode(scenario.getName());
		Log.startTestCase(scenario.getName());
		driver = driverhelper.setDriver(System.getProperty(BROWSER), Boolean.parseBoolean(System.getProperty(HEADLESS)));
		Driverhelper.getDriver().get(Environmenthelper.setUrl(System.getProperty(ENVIRONMENT)));
	}

	@After(order = 1)
	public void endtest(Scenario scenario) {
		if (scenario.isFailed()) {
			childtest.log(Status.FAIL, MarkupHelper
					.createLabel(scenario.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
			scenario.attach(Eventhelper.getScreenshot(driver, scenario.getName()), "image/png", scenario.getName());
		} else {
			childtest.log(Status.PASS,
					MarkupHelper.createLabel(scenario.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}

	}

	@After(order = 0)
	public void teardown(Scenario scenario) throws Exception {
		driver.quit();
		Log.endTestCase(scenario.getName());		
	}

	@AfterAll
	public static void sendEmail() {
		extent.flush();
		Eventhelper.sendEmail();
	}
}

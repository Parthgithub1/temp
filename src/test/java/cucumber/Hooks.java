package cucumber;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.Driverhelper;
import utility.Environmenthelper;
import utility.Eventhelper;
import utility.Log;
import utility.MyScreenRecorder;
import utility.Propertyreader;

public class Hooks {

	Driverhelper driverhelper = new Driverhelper();
	WebDriver driver;

	Propertyreader propertyreader = new Propertyreader();
	Properties pr;

	@Before
	public void setup(Scenario scenario) throws Exception {
		Log.startTestCase(scenario.getName());
		MyScreenRecorder.startRecording(scenario.getName());
		pr = propertyreader.init_prop();
		driver = driverhelper.setDriver(pr.getProperty("browser"));
		Driverhelper.getDriver().get(Environmenthelper.setUrl(pr.getProperty("env")));

	}

	@After(order = 1)
	public void endtest(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.attach(Eventhelper.getScreenshot(driver, scenario.getName()), "image/png", scenario.getName());
		}

	}

	@After(order = 0)
	public void teardown(Scenario scenario) throws Exception {
		driver.quit();
		MyScreenRecorder.stopRecording();
		Log.endTestCase(scenario.getName());
	}

}

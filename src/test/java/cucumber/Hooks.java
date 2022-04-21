package cucumber;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.Driverhelper;
import utility.Environmenthelper;
import utility.Eventhelper;
import utility.Log;
import utility.MyScreenRecorder;

public class Hooks {

	Driverhelper driverhelper = new Driverhelper();
	WebDriver driver;

	@Before
	public void setup(Scenario scenario) throws Exception {
		Log.startTestCase(scenario.getName());
		MyScreenRecorder.startRecording(scenario.getName());
		driver = driverhelper.setDriver(System.getProperty("browser"));
		Driverhelper.getDriver().get(Environmenthelper.setUrl(System.getProperty("env")));

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

package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverhelper {
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver setDriver(String browser,Boolean headless) {

		if (browser == null) {
			browser = "chrome";
		}
		if (headless == null) {
			headless = false;
		}
		
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			if(headless) {
				options.setHeadless(true);
				options.addArguments("window-size=1920,1080");
			}
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));
			break;
		case "firefox":
			FirefoxOptions foptions = new FirefoxOptions();
			if(headless) {
				foptions.setHeadless(true);
			}
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(foptions));
			break;
		case "safari":
			tlDriver.set(new SafariDriver());
			break;
		default:
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}

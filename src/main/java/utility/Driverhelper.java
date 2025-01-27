package utility;

import java.util.*;

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

	public WebDriver setDriver(String browser, Boolean headless) {

		if (browser == null) {
			browser = "firefox";
		}
		if (headless == null) {
			headless = false;
		}

		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			options.setExperimentalOption("prefs", chromePrefs);
			if (headless) {
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--ignore-ssl-errors=yes");
				options.addArguments("--ignore-certificate-error");
			}
			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriverManager.chromedriver().clearResolutionCache().setup();
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));
			break;
		case "firefox":
			FirefoxOptions foptions = new FirefoxOptions();
			if (headless) {
				foptions.addArguments("--headless");
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
		if (headless) {
			Log.info("\n value of headless" + headless);
			Log.info("\n Selected screen size is ----> " + getDriver().manage().window().getSize() + "   <------ \n");

		} else {
			getDriver().manage().window().maximize();
			Log.info("\n value of headless" + headless);
			Log.info("\n Selected screen size is ----> " + getDriver().manage().window().getSize() + "   <------ \n");
		}

		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}

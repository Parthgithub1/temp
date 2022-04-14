package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Eventhelper {

	// add findelement,findelements, click, sendkeys, explicitwait,

	public static WebElement findElement(WebDriver driver, By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (StaleElementReferenceException e) {
			element = driver.findElement(locator);
			Log.error("Getting exception in find element --> " + e.toString());
		}
		return element;
	}

	public static List<WebElement> findElements(WebDriver driver, By locator) {
		List<WebElement> element = null;
		if (isElementDisplayed(driver, locator)) {
			try {
				element = driver.findElements(locator);
			} catch (StaleElementReferenceException e) {
				element = driver.findElements(locator);
				Log.error("Getting exception in find elements --> " + e.toString());
			}
			return element;
		} else {
			return element;
		}
	}

	public static void sendkeys(WebDriver driver, By locator, String val) {
		WebElement element = explicitwait(driver, locator);
		element.clear();
		element.sendKeys(val);
	}

	public static void sendkeywithJS(WebDriver driver, By locator, String val) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		jsexecutor.executeScript("arguments[0].value='" + val + "';", element);
	}

	public static void click(WebDriver driver, By locator) {
		WebElement element = explicitwaitclickable(driver, locator);
		try {
			element.click();
		} catch (ElementClickInterceptedException e) {
			Eventhelper.clickElementwithjs(driver, element);
			Log.error("Getting exception in Click --> " + e.toString());
		} catch (StaleElementReferenceException e) {
			Eventhelper.clickElementwithjs(driver, element);
			Log.error("Getting exception in  Click --> " + e.toString());
		} catch (NoSuchElementException e) {
			Log.error("Getting exception in  Click --> " + e.toString());
			Eventhelper.clickElementwithjs(driver, element);

		}
	}

	public static void clickElementwithjs(WebDriver driver, WebElement element) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		try {
			jsexecutor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			jsexecutor.executeScript("arguments[0].click();", element);
			Log.error("Getting exception in click element with JS --> " + e.toString());
		}
	}

	public static WebElement explicitwait(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			Log.error("Getting exception in explicit wait --> " + e.toString());
		}
		return element;
	}

	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		return findElement(driver, locator).isDisplayed();

	}

	public static String getTextofElement(WebDriver driver, By locator) {
		WebElement element = Eventhelper.findElement(driver, locator);
		return element.getText();
	}

	public static String getTitleOfWebPage(WebDriver driver) {

		return driver.getTitle();
	}

	public static WebElement explicitwaitclickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static byte[] getScreenshot(WebDriver driver, String screenshotName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] source = ts.getScreenshotAs(OutputType.BYTES);
		File fsource = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Failedtestscreenshot/ " + screenshotName + " "
				+ dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(fsource, finalDestination);
		} catch (IOException e) {
			Log.error("Getting exception in get screenshot --> " + e.toString());

		}
		return source;
	}

	public static String getTextOfToast(WebDriver driver, By locator) {
		WebElement element = Eventhelper.explicitwait(driver, locator);

		if (Eventhelper.isElementDisplayed(driver, locator)) {

			element = Eventhelper.findElement(driver, locator);

		}

		return element.getText();

	}

}

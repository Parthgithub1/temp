package utility;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Eventhelper {
	private static SecureRandom random = new SecureRandom();

	// add findelement,findelements, click, sendkeys, explicitwait,

	public static WebElement findElement(WebDriver driver, By locator) {
		WebElement element = null;
		try {
			element = Eventhelper.explicitwait(driver, locator);
		} catch (Exception e) {
			element = driver.findElement(locator);
			Log.error("Getting exception in find element --> " + e.toString());
		}
		return element;
	}

	public static boolean waitUntilElementInvisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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

	public static void doRefresh(WebDriver driver) {
		driver.navigate().refresh();
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
		} catch (ElementClickInterceptedException | StaleElementReferenceException | NoSuchElementException e) {
			Log.error("Getting exception in Click --> " + e.toString());
			Eventhelper.clickElementwithjs(driver, locator);
		}
	}

	public static void clickElementwithjs(WebDriver driver, By locator) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		WebElement element = explicitwaitclickable(driver, locator);
		try {
			jsexecutor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			Log.error("Getting exception in click element with JS --> " + e.toString());
			jsexecutor.executeScript("arguments[0].click();", element);
		}
	}

	public static WebElement explicitwait(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			Log.error("Getting exception in explicit wait --> " + e.toString());
		}
		return element;
	}

	public static WebElement waitUntilElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			Log.error("Getting exception in explicit wait --> " + e.toString());
		}
		return element;
	}

	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		try {
			return findElement(driver, locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementEnabled(WebDriver driver, By locator) {
		return findElement(driver, locator).isEnabled();
	}

	public static String getTextofElement(WebDriver driver, By locator) {
		WebElement element = Eventhelper.findElement(driver, locator);
		return element.getText();
	}

	public static WebElement explicitwaitclickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static Boolean explicitwaitTextToBePresent(WebDriver driver, By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
	}

	public static Boolean waitUntilAttribValueContains(WebDriver driver, By locator, String attrib, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.attributeContains(locator, attrib, value));
	}

	public static Boolean waitUntilAttribValueNotContains(WebDriver driver, By locator, String attrib, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(locator, attrib, value)));
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

	public static void sendKeyboardKeys(WebDriver driver, By locator, String key) {
		WebElement element = explicitwait(driver, locator);
		switch (key) {
		case "tab":
			element.sendKeys(Keys.TAB);
			break;
		case "space":
			element.sendKeys(Keys.SPACE);
			break;
		case "backspace":
			element.sendKeys(Keys.BACK_SPACE);
			break;
		case "enter":
			element.sendKeys(Keys.ENTER);
			break;
		default:
			break;
		}
	}

	public static void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public static void switchToFrame(WebDriver driver, By locator) {
		driver.switchTo().frame(Eventhelper.findElement(driver, locator));
	}

	public static void getURL(WebDriver driver, String url) {
		url = Environmenthelper.setUrl(System.getProperty("env")) + url;
		driver.get(url);
	}

	public static String generateRandomNumber() {
		return String.format("%09d", random.nextInt(999999999));
	}

	public static void threadWait(long miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			Log.info(e);
		}
	}

	public static String getDate(int day) {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, day);
		dt = c.getTime();
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String inputdate = simpleDateFormat.format(dt);
		Log.info("Date in mm-dd-yyyy format latest --> " + inputdate);
		return inputdate;
	}

	public static String getTodaysdateInSpecifiedFormat() {
		String[] suffixes = // 0 1 2 3 4 5 6 7 8 9
				{ "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
						// 10 11 12 13 14 15 16 17 18 19
						"th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
						// 20 21 22 23 24 25 26 27 28 29
						"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
						// 30 31
						"th", "st" };

		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_MONTH);
		String dayStr = day + suffixes[day];
		String outpattern = "MMMM";
		SimpleDateFormat outsimpleDateFormat = new SimpleDateFormat(outpattern);
		String outputdate = outsimpleDateFormat.format(new Date());
		return (outputdate + " " + dayStr);
	}

	public static float numberFormat(float x) {
		String amt = String.valueOf(x);
		if (amt.contains("-")) {
			amt = amt.replace("-", "");
		}
		return Float.parseFloat(amt);
	}

	public static float convertFloatTo2DecimalFloat(float number) {
		DecimalFormat df = new DecimalFormat(".00");
		return Float.valueOf(df.format(number));
	}

	public static String getValueOfAttribute(WebDriver driver, By locator, String attribute) {
		WebElement element = Eventhelper.findElement(driver, locator);
		return element.getAttribute(attribute);
	}

	public static void useActionClassOperation(WebDriver driver, By locator, String methodName) {
		Actions action = new Actions(driver);
		WebElement element = Eventhelper.findElement(driver, locator);
		switch (methodName) {
		case "DoubleClick":
			action.moveToElement(element).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
			break;
		case "Hover":
			action.moveToElement(element).build().perform();
			break;
		default:
			break;
		}
	}

	public static void autoScrollWindow(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
}

package pages;

import java.text.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Eventhelper;

public class AddFundspage {
	private WebDriver driver;
	private By txtaddAmount = By.xpath("//input[@name='amount']");
	private By btncloseIcon = By.xpath("//button[@aria-label='Close']");

	public AddFundspage(WebDriver driver) {
		this.driver = driver;
	}

	public void addAmount(float value) {
		Eventhelper.isElementDisplayed(driver, txtaddAmount);
		Eventhelper.sendkeys(driver, txtaddAmount, String.valueOf(value));

	}

	public By getButtonByText(String btnName) {
		return By.xpath("(//button[normalize-space()='" + btnName + "'])[1]");
	}

	public void clickonCloseIcon() {
		Eventhelper.click(driver, btncloseIcon);
	}

	public boolean isButtonEnabled(String text) {
		return Eventhelper.isElementEnabled(driver, getButtonByText(text));
	}

	public float hopscotchBalanceAfterAddingFund() {
		Eventhelper.threadWait(5000);
		return Float.parseFloat(Eventhelper.getValueOfAttribute(driver, By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"), "zurobalance-amount").replace("$",""));
	}

	public String modalHeader(String text) {
		By xpath = By.xpath("//span[contains(@class,'ModalTitleWithStep_title') and contains(text(),'" + text + "')]");
		return Eventhelper.getTextofElement(driver, xpath);
	}

	public float hopscotchBalanceBeforeAddingFund() {
		Eventhelper.threadWait(5000);
		DecimalFormat df = new DecimalFormat(".00");
		return Float.valueOf(df.format(Float.parseFloat(Eventhelper.getValueOfAttribute(driver, By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"), "zurobalance-amount").replace("$",""))));
	}

}

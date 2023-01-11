package pages;

import org.openqa.selenium.*;
import utility.*;

public class AddFundspage {
	private WebDriver driver;
	private By txtAddAmount = By.xpath("//input[@name='amount']");
	private By btncloseIcon = By.xpath("//button[@aria-label='Close']");

	public AddFundspage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterAmount(float amountofHopscotchBalance) {
		Eventhelper.isElementDisplayed(driver, txtAddAmount);
		Eventhelper.sendkeys(driver, txtAddAmount, String.valueOf(amountofHopscotchBalance));
	}

	public By getButtonByText(String btnName) {
		return By.xpath("(//button[normalize-space()='" + btnName + "'])[1]");
	}

	public void clickonCloseIcon() {
		Eventhelper.click(driver, btncloseIcon);
	}

	public boolean isButtonEnabled(String text) {
		Log.info("withdraw button "+Eventhelper.isElementEnabled(driver, getButtonByText(text)));
		return Eventhelper.isElementEnabled(driver, getButtonByText(text));
	}

	public float hopscotchBalanceAfterAddingFund() {
		Eventhelper.threadWait(5000);
		return Float.parseFloat(Eventhelper.getValueOfAttribute(driver,
				By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"),
				"zurobalance-amount").replace("$", "").replace(",", ""));
	}

	public String modalHeader(String text) {
		By xpath = By.xpath("//span[contains(@class,'ModalTitleWithStep_title') and contains(text(),'" + text + "')]");
		return Eventhelper.getTextofElement(driver, xpath);
	}

	public void clearAmountEnter() {
		Eventhelper.useActionClassOperation(driver, txtAddAmount, Constants.DOUBLECLICK);
	}
}

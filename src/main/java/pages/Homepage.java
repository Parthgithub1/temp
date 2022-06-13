package pages;

import org.openqa.selenium.*;

import utility.Eventhelper;

public class Homepage {
	private WebDriver driver;
	private By btnWithdrawFunds = By.xpath("//button[text()='Withdraw']");

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public float getCurrentHopscotchBalanceAmount() {
		waitUntilWithdrawButtonEnabled();
		return Eventhelper.ConvertFloatTo2DecimalFloat(Float.parseFloat(Eventhelper.getValueOfAttribute(
				driver,
				By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"),
				"zurobalance-amount").replace("$", "")));
	}

	public void waitUntilWithdrawButtonEnabled() {
		Eventhelper.explicitwaitclickable(driver, btnWithdrawFunds);
		Eventhelper.waitUntilAttribValueContains(driver, btnWithdrawFunds, "class", "disable");
		Eventhelper.threadWait(5000);
	}
}

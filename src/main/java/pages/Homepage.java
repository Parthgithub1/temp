package pages;

import org.openqa.selenium.*;

import utility.Eventhelper;

public class Homepage {
	private WebDriver driver;
	private By btnAddFunds = By.xpath("//button[text()='Add funds']");

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public float getCurrentHopscotchBalanceAmount() {
		waitUntilAddFundsButtonEnabled();
		return Eventhelper.ConvertFloatTo2DecimalFloat(Float.parseFloat(Eventhelper.getValueOfAttribute(
				driver,
				By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"),
				"zurobalance-amount").replace("$", "")));
	}

	public void waitUntilAddFundsButtonEnabled() {
		Eventhelper.explicitwaitclickable(driver, btnAddFunds);
		Eventhelper.waitUntilAttribValueContains(driver, btnAddFunds, "class", "disable");
		Eventhelper.threadWait(9000);
	}
}

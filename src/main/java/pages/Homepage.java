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
		waitUntiAddFundsButtonEnabled();
		return Eventhelper.convertFloatTo2DecimalFloat(Float.parseFloat(
				Eventhelper.getValueOfAttribute(driver, By.xpath("//div[@id='HopscotchBalance']"), "zurobalance-amount")
						.replace("$", "").replace(",", "")));
	}

	public void waitUntiAddFundsButtonEnabled() {
		Eventhelper.waitUntilAttribValueNotContains(driver, btnAddFunds, "class", "disable");
		Eventhelper.explicitwaitclickable(driver, btnAddFunds);
		Eventhelper.threadWait(5000);
	}

	public void waituntillDataLoadedOnTheDashboard() {
		Eventhelper.threadWait(5000);
		Eventhelper.waitUntilAttribValueContains(driver, By.xpath("//div[@id='HopscotchBalance']"), "data-loaded",
				"true");
		Eventhelper.threadWait(5000);
	}
}

package pages;

import java.text.DecimalFormat;

import org.openqa.selenium.*;

import utility.Eventhelper;

public class Homepage {
	private WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public float hopscotchBalanceBeforeAddingFund() {
		Eventhelper.threadWait(5000);
		DecimalFormat df = new DecimalFormat(".00");
		return Float.valueOf(df.format(Float.parseFloat(Eventhelper.getValueOfAttribute(driver,
				By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"),
				"zurobalance-amount").replace("$", ""))));
	}
}

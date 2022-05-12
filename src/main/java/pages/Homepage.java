package pages;

import org.openqa.selenium.*;

import utility.Eventhelper;

public class Homepage {
	private WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public float hopscotchBalanceBeforeAddingFund() {
		Eventhelper.threadWait(2000);
		String amountofHBalance = Eventhelper.getTextofElement(driver, By.xpath("//*[contains(@class,'Balance_balance__amount')]"));
		String newamountogHBalance = amountofHBalance.replace("$","");
		float amountBalance = Float.parseFloat(newamountogHBalance);
		return amountBalance;
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Eventhelper;

public class AddFundspage {
	private WebDriver driver;
	private By addAmount = By.xpath("//input[@name='amount']");
	
	public AddFundspage(WebDriver driver) {
		this.driver = driver;		
	}

	public void addAmount(int value) {
		Eventhelper.isElementDisplayed(driver, addAmount);
		Eventhelper.sendkeys(driver, addAmount, String.valueOf(value));

	}

	public By getButtonByText(String btnName) {
		return By.xpath("(//button[normalize-space()='" + btnName + "'])[1]");

	}

	public boolean isButtonEnabled(String text) {
		return Eventhelper.isElementEnabled(driver, getButtonByText(text));

	}

	public float amtText() {
		By xpath = By.xpath("//*[contains(@class,'Balance_balance__amount')]");
		String amountText = Eventhelper.getTextofElement(driver, xpath);
		String hopscotchBalance = amountText.substring(1);
		float amountBalance = Float.parseFloat(hopscotchBalance);
		return amountBalance;

	}

	public String modalHeader(String text) {
		By xpath = By.xpath("//span[contains(@class,'ModalTitleWithStep_title') and contains(text(),'" + text + "')]");
		return Eventhelper.getTextofElement(driver, xpath);
	}
	
	public float getexistingBalance() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualBalanceDisplayed = Eventhelper.getTextofElement(driver, By.xpath("//*[contains(@class,'Balance_balance__amount')]"));
	    String hopscotchBalance = actualBalanceDisplayed.substring(1);
		float amountBalance = Float.parseFloat(hopscotchBalance);
		
		return amountBalance;
	}

}

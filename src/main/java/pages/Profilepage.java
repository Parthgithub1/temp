package pages;

import org.openqa.selenium.*;
import utility.*;

public class Profilepage {

	private WebDriver driver;
	private By txtAreaforAboutinProfile = By.xpath("(//textarea[@name='description'])[1]");
	private By editIcon = By.xpath("//button[contains(@class,'EditButton')]");
	private By editfromBanner = By.xpath("//button[contains(@class,'ProfileTopSection_edit-banner')]");
	private By editAbout = By.xpath("//h4[contains(text(),'About')]/following-sibling::button");
	private By txtWebsite = By.xpath("//input[@name='website']");
	private By txtYearFoubnded = By.xpath("//input[@name='yearFounded']");
	private By ddIndustry = By.xpath("//div[@id='industry']");
	private By txtBusinessName = By.xpath("//input[@name='dbaName']");
	private By txtHandle = By.xpath("//input[@name='handle']");
	private By chooseFileImage = By.id("filePicker");
	private By ddSelecteIndustry;

	public Profilepage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickonChangePicture() {
		WebElement chooseFile = Eventhelper.findElement(driver, chooseFileImage);
		chooseFile.sendKeys(Constants.IMAGEFOLDER);
	}

	public void clickOnButtonfromUploadImagePopUp(String buttonname) {
		By btnXpath = By.xpath("(//button[normalize-space()='" + buttonname + "'])[2]");
		Eventhelper.explicitwait(driver, btnXpath);
		Eventhelper.click(driver, btnXpath);
	}

	public void enterTextforAboutinProfile(String value) {
		Eventhelper.sendkeys(driver, txtAreaforAboutinProfile, value);
	}

	public void clickonEditIcon() {
		Eventhelper.click(driver, editIcon);
	}

	public void clickonEditIconforAbout() {
		Eventhelper.click(driver, editAbout);
	}

	public void clickonEditfromBanner() {
		Eventhelper.click(driver, editfromBanner);
	}

	public boolean isTextDisplayedofEditProfile(String text) {
		By xpath = By.xpath("//form//*[contains(text(),'" + text + "')]");
		Eventhelper.explicitwait(driver, xpath);
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void enterdetailsofBusiness(String businessName, String handle, String industry, String webSite,
			String yearFound) {
		Eventhelper.clearTextwithdoubleClickusingActionClass(driver, txtBusinessName);
		Eventhelper.sendkeys(driver, txtBusinessName, businessName);
		Eventhelper.clearTextwithdoubleClickusingActionClass(driver, txtHandle);
		Eventhelper.sendkeys(driver, txtHandle, handle);
		Eventhelper.clearTextwithdoubleClickusingActionClass(driver, ddIndustry);
		ddSelecteIndustry = By.xpath("//div[text()='" + industry + "']");
		Eventhelper.click(driver, ddSelecteIndustry);
		Eventhelper.clearTextwithdoubleClickusingActionClass(driver, txtWebsite);
		Eventhelper.sendkeys(driver, txtWebsite, webSite);
		Eventhelper.clearTextwithdoubleClickusingActionClass(driver, txtYearFoubnded);
		Eventhelper.sendkeys(driver, txtYearFoubnded, yearFound);
	}

	public void clickonViewAllOption(String text) {
		By btnViewAll = By.xpath("//a[normalize-space()='" + text + "']");
		Eventhelper.click(driver, btnViewAll);
	}

	public boolean verificationofUpdatedProfile(String businessName, String handle, String industry, String webSite,
			String yearFound) {
		boolean flag = false;
		By businessNameVerification = By.xpath("//span[@class='InfoHeader_header__title__sl2WG']");
		By handleVerification = By.xpath("//p[contains(@class,'InfoHeader_header__handle')]");
		By industryVerification = By.xpath("//p[contains(@class,'InfoHeader_header__location')]");
		By webSiteVerification = By.xpath("//a[contains(.,'" + webSite + "')]");
		By yearFoundVerification = By.xpath("//p[contains(.,'" + yearFound + "')]");
		
		if (businessName.equals(Eventhelper.getTextofElement(driver, businessNameVerification))
				&& Eventhelper.getTextofElement(driver, handleVerification).contains(handle)
				&& Eventhelper.getTextofElement(driver, industryVerification).contains(industry)
				&& webSite.equals(Eventhelper.getTextofElement(driver, webSiteVerification))
				&& Eventhelper.isElementDisplayed(driver, yearFoundVerification)) {
			flag = true;
		}
		return flag;
	}

	public boolean verificationofAbout(String aboutText) {
		boolean flag = false;
		By txtAbout = By.xpath("//div[contains(@class,'CompanyDescription_company__about')]");
		if (Eventhelper.getTextofElement(driver, txtAbout).contains(aboutText)) {
			flag = true;
		}
		return flag;
	}
}
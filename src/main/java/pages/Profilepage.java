package pages;

import org.openqa.selenium.*;

import com.github.javafaker.Faker;

import utility.*;

public class Profilepage {

	private WebDriver driver;
	private By txtAreaforAboutinProfile = By.xpath("(//textarea[@name='description'])[1]");
	private By editIcon = By.xpath("(//button[contains(@class,'btn btn--icon btn--small icon-button light')])[1]");
	private By editfromBanner = By.xpath("//button[contains(@class,'ProfileTopSection_edit-banner')]");
	private By editAbout = By.xpath("//h4[contains(text(),'About')]//following-sibling::button");
	private By txtWebsite = By.xpath("//input[@name='website']");
	private By txtYearFoubnded = By.xpath("//input[@name='yearFounded']");
	private By ddIndustry = By.xpath("//div[@id='industry']");
	private By txtBusinessName = By.xpath("//input[@name='dbaName']");
	private By txtHandle = By.xpath("//input[@name='handle']");
	private By chooseFileImage = By.id("filePicker");
	private By txtFirstname = By.xpath("//input[@name='firstName']");
	private By txtLastname = By.xpath("//input[@name='lastName']");
	private By txtEmailID = By.xpath("//input[@name='emailId']");
	private By txtRole = By.xpath("//input[@name='role']");
    private String fname;
    private String lname;
    private String email;
	
    Faker faker = new Faker();

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
		By xpath = By.xpath("//*[contains(text(),'" + text + "')]");
		Eventhelper.explicitwait(driver, xpath);
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void enterdetailsofBusiness(String businessName, String handle, String industry, String webSite,
			String yearFound) {
		Eventhelper.useActionClassOperation(driver, txtBusinessName, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtBusinessName, businessName);
		Eventhelper.useActionClassOperation(driver, txtHandle, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtHandle, handle);
		By ddCurrentIndustry = By.xpath("//div[@class='select__form-field__single-value css-qc6sy-singleValue']");
		if (Eventhelper.getTextofElement(driver, ddCurrentIndustry).equalsIgnoreCase("Accounting")) {
			Log.info("Current industry is Accounting so no need to change the value of the industry in dropdown"
					+ industry);
		} else {
			Eventhelper.useActionClassOperation(driver, ddIndustry, Constants.DOUBLECLICK);
			By ddSelecteIndustry = By.xpath("//div[@class='select__form-field__input-container css-ackcql']");
			Eventhelper.click(driver, ddSelecteIndustry);
		}
		Eventhelper.useActionClassOperation(driver, txtWebsite, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtWebsite, webSite);
		Eventhelper.useActionClassOperation(driver, txtYearFoubnded, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtYearFoubnded, yearFound);
	}

	public void clickonViewAllOption(String text) {
		By btnViewAll = By.xpath("//a[normalize-space()='" + text + "']");
		Eventhelper.click(driver, btnViewAll);
	}

	public boolean isVerificationOfUpdatedProfileMatched(String businessName, String handle, String industry, String webSite,
			String yearFound) {
		boolean flag = false;
		By businessNameVerification = By.xpath("//h3[ contains(@class,'InfoHeader_header__title') ]");
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
		By txtAbout = By.xpath("//p[contains(@class,'CompanyDescription_company__about')]");
		if (Eventhelper.getTextofElement(driver, txtAbout).contains(aboutText)) {
			flag = true;
		}
		return flag;
	}

	public void enterWebsite(String website) {
		Eventhelper.useActionClassOperation(driver, txtWebsite, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtWebsite, website);
		Eventhelper.sendKeyboardKeys(driver, txtWebsite, "tab");
	}

	public void enterYearFounded(String yearFounded) {
		Eventhelper.useActionClassOperation(driver, txtYearFoubnded, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtYearFoubnded, yearFounded);
		Eventhelper.sendKeyboardKeys(driver, txtYearFoubnded, "tab");
	}

	public void enterHandle(String handle) {
		Eventhelper.useActionClassOperation(driver, txtHandle, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtHandle, handle);
		Eventhelper.sendKeyboardKeys(driver, txtHandle, "tab");
	}

	public void enterContactDetailsOnAnotherUsersProfile() {
		fname = faker.name().firstName();
		lname = faker.name().lastName();
		Eventhelper.sendkeys(driver, txtFirstname, fname);
		Eventhelper.sendkeys(driver, txtLastname, lname);
		email= fname + lname + Constants.MAILINATORDOTCOM;
		Eventhelper.sendkeys(driver, txtEmailID, email);
		Eventhelper.sendkeys(driver, txtRole, faker.company().profession());

	}
 
	public Boolean isEmailOfAddedContactOnAnotherUsersProfilePageFound() {
		By lblEmailID= By.xpath("//table[contains(@class,'profile-contacts')]//tr//td[2]//span");
		Eventhelper.explicitwait(driver, lblEmailID);
		return (fname + lname + "@mailinator.com").equalsIgnoreCase(Eventhelper.getTextofElement(driver,lblEmailID)) ;
	}
	
	public void clickOnMenuOfAddedContact(String menuOption)
	{
	 By lblMenu= By.xpath("//span[normalize-space()='"+ email.toLowerCase()+"']/ancestor::td/following-sibling::td[2]");
	 By lblMenuOption=By.xpath("//div[normalize-space()='"+menuOption+"']");	
		Eventhelper.explicitwaitclickable(driver, lblMenu);
		Eventhelper.autoScrollWindow(driver);
	    Eventhelper.click(driver, lblMenu);
		Eventhelper.click(driver, lblMenuOption);
	}
	
	public void editTheAlreadyAddedContact()
	{
		fname = faker.name().firstName();
		lname = faker.name().lastName();
		Eventhelper.useActionClassOperation(driver, txtFirstname, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtFirstname, fname);
		Eventhelper.useActionClassOperation(driver, txtLastname, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtLastname, lname);
		Eventhelper.useActionClassOperation(driver, txtRole, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtRole, faker.company().profession());
	}
	
	public Boolean isUpdatedDetailsOfAddedContactOnAnotherUsersProfilePageDone() {
		By lblName= By.xpath("(//td)[1]//span");
		Eventhelper.explicitwaitTextToBePresent(driver, lblName,(fname +" "+ lname));
		return (fname +" "+ lname).equalsIgnoreCase(Eventhelper.getTextofElement(driver,lblName)) ;
	}
	
	public Boolean isContactDeleted()
	{		
		return Eventhelper.isElementDisplayed(driver, txtEmailID);
	}
}

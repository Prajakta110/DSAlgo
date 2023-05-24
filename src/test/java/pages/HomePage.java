package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utilities.Log;

public class HomePage {

	WebDriver driver;

	

	@FindBy(xpath = "//a[@href='/login']") WebElement loginBtn;
	@FindBy(xpath = "//a[@href='data-structures-introduction']") WebElement dataStructureBtn;
	@FindBy(xpath = "//a[@href='array']") WebElement arrayBtn;
	@FindBy(xpath = "//a[@href='stack']") WebElement stackBtn;
	@FindBy(xpath = "//div[contains(@class, 'alert')]") WebElement errorMsg;
	@FindBy(xpath = "//a[@href='']") WebElement signedInUser;
	@FindBy(xpath = "//a[@href='/logout']") WebElement signOutBtn;
	@FindBy(linkText="Register")WebElement registrationLink;

	//@FindBy(xpath = "//div[contains(@class, 'alert')]") WebElement errorMsg;
	
	@FindBy(xpath = "//a[@href='']") WebElement signedInUser;
	 
	 @FindBy(xpath = "//a[@href='/logout']") WebElement signOutBtn;
	 

	@FindBy(xpath = "//a[@href='/login']")
	WebElement loginBtn;
	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement dataStructureBtn;
	@FindBy(xpath = "//div[contains(@class, 'alert')]")
	WebElement errorMsg;
	@FindBy(xpath = "//button")
	WebElement getStartedBtn;
	@FindBy(xpath = "//a[@href='/register']")
	WebElement registerBtn;
	@FindBy(xpath = "//a[@href='/login']")
	WebElement signInBtn;
	@FindBy(xpath = "//a[contains(text(),'Data Structures')]")
	WebElement dataStructuresDropdown;
	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement dataStructureGetStartedBtn;
	@FindBy(xpath = "//div[contains(@class, 'alert alert-primary')]")
	WebElement validateErrorMsg;
	@FindBy(xpath = "//a[@href=\"array\"]")
	WebElement ArrayGetStartedBtn;
	@FindBy(xpath = "//div[contains(@class,\"alert alert-primary\")]")
	WebElement ValidateArrayErrorMsg;
	@FindBy(xpath = "//a[@href=\"linked-list\"]")
	WebElement LinkedListGetStartedBtn;
	@FindBy(xpath = "//div[contains(@class,\"alert alert-primary\")]")
	WebElement ValidateLinkedListErrorMsg;
	@FindBy(xpath = "//a[@href=\"stack\"]")
	WebElement StackGetStartedBtn;
	@FindBy(xpath = "//a[@href=\"queue\"]")
	WebElement QueueGetStartedBtn;
	@FindBy(xpath = "//a[@href=\"tree\"]")
	WebElement TreeGetStartedBtn;
	@FindBy(xpath = "//a[@href=\"graph\"]")
	WebElement GraphGetStartedBtn;
	@FindBy(xpath = "//a[//a[@href=\"#\"]")
	WebElement ClickonDataStructureDropDown;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 public void GoToHomePage() {
	 driver.navigate().to(FileReaderManager.getInstance().getConfigReader().
	 getHomeUrl()); Log.info("User navigated to Home Page"); }
	 
	 //public void VerifyHomePageURL() { Assert.assertEquals(driver.getCurrentUrl(),
	 //FileReaderManager.getInstance().getConfigReader().getHomeUrl());
	 //Log.info("Verifies that user is on Home Page"); }
	 
	 public void VerifyNotSignedIn() { Assert.assertEquals(loginBtn.getText(),
	 FileReaderManager.getInstance().getConfigReader().getLoginBtnText());
	 Log.info("Verifies that user is not logged in"); }
	 
	 public void VerifySignedIn() {
	 Assert.assertEquals(signedInUser.getText().toLowerCase(),
	 FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
	 Log.info("Verifies that user is logged in"); }
	  
	 public void ClickOnSignIn() { loginBtn.click();
	 Log.info("User clicked on Sign in"); }
	 
	 //public void ClickOnDataStructures() { dataStructureBtn.click();
	 //Log.info("User clicked on Get Started button for Data Structure"); }
	 
	 //public void ClickOnArray() { arrayBtn.click();
	 //Log.info("User clicked on Get Started button for Array"); }
	 
	 //public void VerifyLoginErrorMsg() { Assert.assertEquals(errorMsg.getText(),
	 //FileReaderManager.getInstance().getConfigReader().getInvalidLoginMsg());
	  //Log.info("Verified the message that user is not logged in"); }
	 
	  public void VerifyLoginSuccessMsg() { Assert.assertEquals(errorMsg.getText(),
	  FileReaderManager.getInstance().getConfigReader().getValidLoginMsg());
	  Log.info("Verified the success message for log in"); }
	  
	  public void ClickOnSignOutBtn() { signOutBtn.click();
	 Log.info("User clicked on Sign out"); }
	 
	 public void VerifyLogoutSuccessMsg() {
	 Assert.assertEquals(errorMsg.getText(),
	 FileReaderManager.getInstance().getConfigReader().getLogoutSuccessMsg());
	 Log.info("Verified the success message for log out"); }
	

	public void VerifyHomePageURL() {
		Log.info(driver.getCurrentUrl());
		Log.info(FileReaderManager.getInstance().getConfigReader().getHomeUrl());
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getHomeUrl());
	}

	public void VerifyGetStartedButton() {

		Assert.assertEquals(getStartedBtn.getText(), "Get Started");

	}

	public void ClickOnRegisterBtn() {
		registerBtn.click();
	}

	public void Register() {

		Assert.assertEquals(registerBtn.getText(),
				FileReaderManager.getInstance().getConfigReader().getRegisterBtnText());

	}

	public void ClickOnSignInBtn() {
		signInBtn.click();
	}

	public void SignIn() {

		Assert.assertEquals(signInBtn.getText(), FileReaderManager.getInstance().getConfigReader().getLoginBtnText());

	}

	public void VerifyNotLoggedIn() {
		Assert.assertEquals(loginBtn.getText(), FileReaderManager.getInstance().getConfigReader().getLoginBtnText());
	}

	public void ClickOnDataStructures() {
		dataStructureBtn.click();
	}

	public void ClickOnDataStructuresDropdown() {
		dataStructuresDropdown.click();
	}


	public void validateErrorMsg() {
    Assert.assertEquals(errorMsg.getText(), FileReaderManager.getInstance().getConfigReader().getInvalidLoginMsg());
  }

	public void VerifyLoginErrorMsg()
	{
		Assert.assertEquals(errorMsg.getText(), FileReaderManager.getInstance().getConfigReader().getInvalidLoginMsg());

	}
  
  public void ClickOnStack()
	{
		stackBtn.click();
		Log.info("User clicked on Get Started button for Stack");
	}

	public void ClickOnArray() {
		ArrayGetStartedBtn.click();
	}

	public void ClickonArrayGetStartedBtn() {
		ArrayGetStartedBtn.click();
	}

	public void ValidateArrayErrorMsg() {
		Assert.assertEquals(errorMsg.getText(), FileReaderManager.getInstance().getConfigReader().getInvalidLoginMsg());
	}

	public void ClickonLinkedListGetStartedBtn() {
		LinkedListGetStartedBtn.click();
	}

	public void ValidateLinkedListErrorMsg() {
		Assert.assertEquals(errorMsg.getText(), FileReaderManager.getInstance().getConfigReader().getInvalidLoginMsg());
	}

	public void ClickonStackGetStartedBtn() {
		StackGetStartedBtn.click();
	}

	public void ClickonQueueGetStartedBtn() {
		QueueGetStartedBtn.click();
	}

	public void ClickonTreeGetStartedBtn() {
		TreeGetStartedBtn.click();
	}

	public void ClickonGraphGetStartedBtn() {
		GraphGetStartedBtn.click();
	}

	public void ClickonDataStructureLinkname(String linkname) {
		WebElement element = driver.findElement(By.xpath("//a[@href='" + linkname + "']"));
		element.click();
	}

	public void ClickonDataStructureDropDown(String linkname) {
		WebElement element = driver.findElement(By.xpath("//a[@href='" + linkname + "']"));
		element.click();
	}

	public void VerifyLoginErrorMsg() {
		Assert.assertEquals(errorMsg.getText(), "You are not logged in");
	}
	
	public void ClickRegistrationLink()
	{
		registrationLink.click();
	}
}

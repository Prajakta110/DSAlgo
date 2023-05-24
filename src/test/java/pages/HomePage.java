package pages;

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
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void GoToHomePage()
	{
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getHomeUrl());
		Log.info("User navigated to Home Page");
	}

	public void VerifyHomePageURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getHomeUrl());
		Log.info("Verifies that user is on Home Page");
	}
	
	public void VerifyNotSignedIn()
	{
		Assert.assertEquals(loginBtn.getText(), FileReaderManager.getInstance().getConfigReader().getLoginBtnText());
		Log.info("Verifies that user is not logged in");
	}
	
	public void VerifySignedIn()
	{
		Assert.assertEquals(signedInUser.getText().toLowerCase(), FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
		Log.info("Verifies that user is logged in");
	}
	
	public void ClickOnSignIn()
	{
		loginBtn.click();
		Log.info("User clicked on Sign in");
	}
	
	public void ClickOnDataStructures()
	{
		dataStructureBtn.click();
		Log.info("User clicked on Get Started button for Data Structure");
	}
	
	public void ClickOnArray()
	{
		arrayBtn.click();
		Log.info("User clicked on Get Started button for Array");
	}
	
	public void ClickOnStack()
	{
		stackBtn.click();
		Log.info("User clicked on Get Started button for Stack");
	}
	
	public void VerifyLoginErrorMsg()
	{
		Assert.assertEquals(errorMsg.getText(), FileReaderManager.getInstance().getConfigReader().getInvalidLoginMsg());
		Log.info("Verified the message that user is not logged in");
	}
	
	public void VerifyLoginSuccessMsg()
	{
		Assert.assertEquals(errorMsg.getText(), FileReaderManager.getInstance().getConfigReader().getValidLoginMsg());
		Log.info("Verified the success message for log in");
	}
	
	public void ClickOnSignOutBtn()
	{
		signOutBtn.click();
		Log.info("User clicked on Sign out");
	}
	
	public void VerifyLogoutSuccessMsg()
	{
		Assert.assertEquals(errorMsg.getText(), FileReaderManager.getInstance().getConfigReader().getLogoutSuccessMsg());
		Log.info("Verified the success message for log out");
	}
	
	public void ClickRegistrationLink()
	{
		registrationLink.click();
	}
}

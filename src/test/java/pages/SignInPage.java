package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utilities.Log;

public class SignInPage {

	WebDriver driver;
	
	@FindBy(name = "username") WebElement userName;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//input[@value='Login']") WebElement loginButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement errorMessage;
	
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SignIn()
	{
		userName.sendKeys(FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getDSAlgoPassword());
		loginButton.click();
		Log.info("User logged in to the application. Username - " 
				+ FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
	}
	
	public void EnterUserName(String username)
	{
		userName.sendKeys(username);
		Log.info("User enterd the username on Sign in page");
	}
	
	public void EnterPassword(String passwordVal)
	{
		password.sendKeys(passwordVal);
		Log.info("User enterd the password on Sign in page");
	}
	
	public void ClickOnLogin()
	{
		loginButton.click();
		Log.info("User clicked on Sign in button on Sign in page");
	}
	
	public void VerifyErrorMsg(String message)
	{
		Assert.assertEquals(errorMessage.getText(), message);
		Log.info("Verified that user is getting valid message for invalid inputs on Sign in page"
				+ "Expected message - " + message + ", Actual message - " + errorMessage.getText());
		
	}
}

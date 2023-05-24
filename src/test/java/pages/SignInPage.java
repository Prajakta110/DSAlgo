package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import managers.FileReaderManager;
import readers.ConfigFileReader;
import managers.DriverManager;
import utilities.Log;

public class SignInPage {

	WebDriver driver;
	String loginurl = ConfigFileReader.loginPage();
	String registerurl = ConfigFileReader.registerPageURL();

	
	@FindBy(name = "username") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//input[@value='Login']") WebElement loginButton;
	@FindBy(xpath = "//div[contains(text(),'Invalid Username and Password')]")
	WebElement alertMsg;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/a[1]")
	WebElement registerlink;
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	WebElement successLogin;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement errorMessage;
	
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SignIn()
	{
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getDSAlgoPassword());
		loginButton.click();
		Log.info("User logged in to the application. Username - " 
				+ FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
	}
	//To get Log in URL
	public void getLoginurl() {
		driver.get(loginurl);
	}
	
	public void EnterUserName(String userName)
	{
		username.sendKeys(userName);
		Log.info("User enterd the username on Sign in page");
	}
	
	public void EnterPassword(String passWord)
	{
		password.sendKeys(passWord);
		Log.info("User enterd the password on Sign in page");
	}
	
	public void ClickOnLogin()
	{
		loginButton.click();
		Log.info("User clicked on Sign in button on Sign in page");
	}
	
	public String successAlert() {
		String successMsg = successLogin.getText();
		return successMsg;
	}

	public String invalidAlert() {
		String alertMessage = alertMsg.getText();
		return alertMessage;
	}

	public String validateUsernamefield(String validationMessge) {
		String message = username.getAttribute("validationMessage");
		System.out.println("message");
		return message;

	}

	public String validatePasswordfield(String validationMessge) {
		String message = password.getAttribute("validationMessage");
		System.out.println("message");
		return message;

	}

	public void register() {
		registerlink.click();
	}

	public String register_page() {
		String title = driver.getTitle();
		return title;
	}
	
    public void VerifyErrorMsg(String message)
	{
		Assert.assertEquals(errorMessage.getText(), message);
		Log.info("Verified that user is getting valid message for invalid inputs on Sign in page"
				+ "Expected message - " + message + ", Actual message - " + errorMessage.getText());
		
	}
}

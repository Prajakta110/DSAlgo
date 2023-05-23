package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import context.TestContext;
import managers.FileReaderManager;
import utilities.Log;

public class RegisterPage
{
		WebDriver driver;
		Actions action;
		//TestContext testContext;		
		//HomePage homePage;
		//SignInPage signinPage;
		//RegisterPage registerPage;
		String output;
			
		@FindBy(linkText="Register")WebElement registratioLink;
		@FindBy(xpath="//input[@value='Register']")WebElement registrationButton;
		@FindBy(name="username")WebElement userNametextBox;
		@FindBy(xpath="//input[@name='password1']")WebElement passwordtextBox;
		@FindBy(xpath="//*[@id=\"id_password\"]")WebElement loginpagepasswordtextBox;		
		@FindBy(xpath="//button[@class='btn']")WebElement getStartedButton ;
		@FindBy(xpath="//input[@name='password2']")WebElement confirmpasswordtextBox;
		@FindBy(xpath="//div[@class='alert alert-primary']")WebElement accountsuceessmessage;
		@FindBy(xpath="/html/body/div[2]/div/div[2]/a")WebElement loginLink ;
		@FindBy(xpath="//input[@type='submit']")WebElement loginButton;
		@FindBy(linkText="NumpyNinja")WebElement numpyLink;
		@FindBy(linkText="Sign in")WebElement signInLink;
		@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")WebElement dropDown;
		@FindBy(xpath="//a[@href='/array']")WebElement dropDownMenu;
		
		public RegisterPage(WebDriver driver)
		{	
			this.driver = driver;
			Log.info("We are in Register page constructor - " + this.driver.toString());
			PageFactory.initElements(driver, this);		
			Log.info("Get First Information");
			//testContext = context;
			//homePage = testContext.getPageObjectManager().getHomePage();
			//registerPage=testContext.getPageObjectManager().getRegistrationPage();
		}
	
		public void GetStartedButtonClick()
		{
			driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
			getStartedButton.click();
		}
		public void GoToHomePage()
		{
			
			driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getHomeUrl());
			Log.info("User navigated to Home Page");					
		}
		
		public void ClickRegistrationLink()
		{
			registratioLink.click();
		}
		
		public void VerifyRegistrationUrl()
		{
			Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getRegisterUrl());
			Log.info("Verifies that user is on Registration Page");
		}
		
		public void ClickRegistrationButton()
		{
			registrationButton.click();
		}
		
		public void InvalidUserNameAndPassword()
		{		
			userNametextBox.clear();
			passwordtextBox.clear();
			confirmpasswordtextBox.clear();		
			registrationButton.click();
		}
		
		public void VerifyErrorMessage()
		{
			Log.info("Verifies Error message.");
		}
		
		public void validateUser(String unm,String pwd,String cpwd,String status)
		{
			driver.navigate().refresh();
			action = new Actions(driver);
			action.sendKeys(userNametextBox, unm).build().perform();
			action.sendKeys(passwordtextBox, pwd).build().perform();
			action.sendKeys(confirmpasswordtextBox, cpwd).build().perform();			
			System.out.println("User Name:"+unm +"  Password:"+pwd +"  Confirm password:" +cpwd);		
		}
	
		public void User71() 
		{
			userNametextBox.sendKeys("User7");
			loginpagepasswordtextBox.sendKeys("Test1177");
		}
	
		public void clearTextbox()
		{
			userNametextBox.clear();
			passwordtextBox.clear();
			confirmpasswordtextBox.clear();
		}
		
		public void RegistrationSuccess()
		{
			Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getHomeUrl());
			Log.info("Verifies that user successfully Register.");
		}
				
		public void RegistrationFail()
		{
			Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getRegisterUrl());
			Log.info("Registration Fail, user is on registration page.");
		}	
		
		public void ClickLoginLink() 
		{
			loginLink.click();	
		}
		
		public void ClickLoginButton() 
		{
			loginButton.click();	
		}
		
		public void ClickNumpyNinjaLogo()
		{
			numpyLink.click();
		}
		
		public void RedirectToLandingPage()
		{
			Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
			Log.info("User redirect to Landing page");
		}
		
		public void ClickSignLink()
		{
			signInLink.click();
		}
		
		public void RedirectToLoginPage()
		{
			Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getHomeUrl());
			Log.info("Registration Fail, user is on registration page.");	
		}
}
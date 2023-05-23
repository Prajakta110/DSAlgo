package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.LoggerLoad;

public class RegisterPage
{
		WebDriver driver;
		Actions action;
		
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
			PageFactory.initElements(driver, this);		
			LoggerLoad.info("Get First Information");
		}
	
		public void GetStartedButtonClick()
		{
			 getStartedButton.click();
		}
		public void GoToRegistrationPage()
		{
			driver.get("https://dsportalapp.herokuapp.com/home");			
		}
		
		public void ClickRegistrationLink()
		{
			registratioLink.click();
		}
		
		public void VerifyRegistrationUrl()
		{
			System.out.println("drive-"+driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/register");
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
			System.out.println("Error message should Display");
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
			Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/home");	
		}
				
		public void RegistrationFail()
		{
			Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/register");
			System.out.println("Registration Fail, stay on same page.");
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
			Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/");
		}
		
		public void ClickSignLink()
		{
			signInLink.click();
		}
		
		public void RedirectToLoginPage()
		{
			Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/home");			
		}
		// Vimala Changes start
		public void VerifyRegisterPageURL()
		{
			Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/register");
		}
		
		public void VerifySignInPageURL()
		{
			Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/login");
		}
		// Vimala Changes end
}
	
	


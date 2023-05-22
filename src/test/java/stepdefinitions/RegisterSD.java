package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;
import readers.ExcelReader;
import utils.TrialScreenshots;

public class RegisterSD 
{
	WebDriver driver;	
	RegisterPage registerPage;
	TrialScreenshots trialscreenshots;
	ExcelReader excelReader;
	String errorMessage;
	
	public RegisterSD()
	{
		driver = DriverFactory.getDriver("chrome");
		registerPage = new RegisterPage(driver);
		trialscreenshots =new TrialScreenshots(driver);
		excelReader=new ExcelReader();
	}
	
	@Given("Ds Algo  portal home page")
	public void ds_algo_portal_home_page() throws IOException 
	{	
		registerPage.GoToRegistrationPage();
	}

	@When("The user clicks the Register link")
	public void the_user_clicks_the_register_link()
	{		
		registerPage.GoToRegistrationPage();
		registerPage.ClickRegistrationLink();
	}

	@Then("The user should be redirected to registration page.")
	public void the_user_should_be_redirected_to_registration_page() 
	{
		registerPage.VerifyRegistrationUrl();
	}
	
	// Scenario1 @EmptyTextBoxGetRegister
	@Given("user is on registration page")
	public void user_is_on_registration_page() 
	{
		registerPage.VerifyRegistrationUrl();
	}

	@When("user click register button with empty Unm and pwd textbox")
	public void user_click_register_button() 
	{
		registerPage.ClickRegistrationButton();
	}

	@Then("warning message should display")
	public void warning_message_should_display()
	{
		registerPage.VerifyRegistrationUrl();
	}

	@Then("Registration Status Success")
	public void registration_status_success() 
	{
		registerPage.RegistrationSuccess();
	}

	@Then("Registration Status Fail")
	public void registration_status_fail()
	{
		registerPage.RegistrationFail();
	}
	
	@Then("Registration Status Pass")
	public void registration_status_pass() 
	{
		registerPage.RegistrationSuccess();
	}
	
	@When("user click login link to check successful registration")
	public void user_click_login_link_to_check_successful_registration()
	{
		registerPage.ClickLoginLink();
		registerPage.User71();
		registerPage.ClickLoginButton();	  
	}

	@When("user click NumpyNinja link.")
	public void user_click_numpy_ninja_link() 
	{
		registerPage.ClickNumpyNinjaLogo();
	}

	@Then("user redirect to landing page")
	public void user_redirect_to_landing_page() 
	{
		registerPage.RedirectToLandingPage();
		registerPage.GoToRegistrationPage();
	}

	@When("user click sign in link.")
	public void user_click_sign_in_link() 
	{
		registerPage.ClickSignLink();
	}
	
	@Then("user logged into website")
	public void user_redirect_to_login_page() {
		registerPage.RedirectToLoginPage();
	}
	
	@When("user enter userName from {string} and rownumber {int}")
	public void user_enter_user_name_from_and_rownumber(String sheetName, Integer rownumber) throws InvalidFormatException,IOException 
	{
		Map<String, String>testdata=excelReader.ReadExcelFile(sheetName).get(rownumber);
		registerPage.validateUser(testdata.get("UserName"),testdata.get("Password"),testdata.get("Confirmpwd"),testdata.get("Status"));
		errorMessage=testdata.get("expectedmessage");
	}

	@Then("verify Registration Status")
	public void registration_status()
	{	
		System.out.println("Registration success");	
	}
}

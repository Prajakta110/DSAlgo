package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import readers.ExcelReader;
import utils.TrialScreenshots;

public class RegistrationPageSD 
{
	WebDriver driver;	
	RegistrationPage registrationPage;
	TrialScreenshots trialscreenshots;
	ExcelReader excelReader;
	String errorMessage;
	
	@Before
	public void Setup()
	{
		driver = DriverFactory.getDriver("chrome");
		registrationPage = new RegistrationPage(driver);
		trialscreenshots =new TrialScreenshots(driver);
		excelReader=new ExcelReader();
	}
	
	@Given("Ds Algo  portal home page")
	public void ds_algo_portal_home_page() throws IOException 
	{	
		registrationPage.GoToRegistrationPage();
	}

	@When("The user clicks the Register link")
	public void the_user_clicks_the_register_link()
	{		
		registrationPage.GoToRegistrationPage();
		registrationPage.ClickRegistrationLink();
	}

	@Then("The user should be redirected to registration page.")
	public void the_user_should_be_redirected_to_registration_page() 
	{
		registrationPage.VerifyRegistrationUrl();
	}
	
	// Scenario1 @EmptyTextBoxGetRegister
	@Given("user is on registration page")
	public void user_is_on_registration_page() 
	{
		registrationPage.VerifyRegistrationUrl();
	}

	@When("user click register button with empty Unm and pwd textbox")
	public void user_click_register_button() 
	{
		registrationPage.ClickRegistrationButton();
	}

	@Then("warning message should display")
	public void warning_message_should_display()
	{
		registrationPage.VerifyRegistrationUrl();
	}

	@Then("Registration Status Success")
	public void registration_status_success() 
	{
		registrationPage.RegistrationSuccess();
	}

	@Then("Registration Status Fail")
	public void registration_status_fail()
	{
		registrationPage.RegistrationFail();
	}
	
	@Then("Registration Status Pass")
	public void registration_status_pass() 
	{
		registrationPage.RegistrationSuccess();
	}
	
	@When("user click login link to check successful registration")
	public void user_click_login_link_to_check_successful_registration()
	{
		registrationPage.ClickLoginLink();
		registrationPage.User71();
		registrationPage.ClickLoginButton();	  
	}

	@When("user click NumpyNinja link.")
	public void user_click_numpy_ninja_link() 
	{
		registrationPage.ClickNumpyNinjaLogo();
	}

	@Then("user redirect to landing page")
	public void user_redirect_to_landing_page() 
	{
		registrationPage.RedirectToLandingPage();
		registrationPage.GoToRegistrationPage();
	}

	@When("user click sign in link.")
	public void user_click_sign_in_link() 
	{
		registrationPage.ClickSignLink();
	}
	
	@Then("user logged into website")
	public void user_redirect_to_login_page() {
		registrationPage.RedirectToLoginPage();
	}
	
	@When("user enter userName from {string} and rownumber {int}")
	public void user_enter_user_name_from_and_rownumber(String sheetName, Integer rownumber) throws InvalidFormatException,IOException 
	{
		Map<String, String>testdata=excelReader.ReadExcelFile(sheetName).get(rownumber);
		registrationPage.validateUser(testdata.get("UserName"),testdata.get("Password"),testdata.get("Confirmpwd"),testdata.get("Status"));
		errorMessage=testdata.get("expectedmessage");
	}

	@Then("verify Registration Status")
	public void registration_status()
	{	
		System.out.println("Registration success");	
	}
}

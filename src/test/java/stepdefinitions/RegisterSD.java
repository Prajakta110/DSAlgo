package stepdefinitions;

import java.io.IOException;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.RegisterPage;
import pages.SignInPage;
import context.TestContext;
import pages.HomePage;
import utilities.HandleExceptions;
import utilities.Log;

public class RegisterSD 
{
	WebDriver driver;	
	RegisterPage registerPage;
	//String errorMessage;
	SignInPage signinPage;
	TestContext testContext;
	HomePage homePage;
	
	public RegisterSD(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		registerPage = testContext.getPageObjectManager().getRegistrationPage();
	}
	
	@Given("Ds Algo  portal home page")
	public void ds_algo_portal_home_page() throws IOException 
	{	
		try
		{
			Log.startTestCase();
			homePage.GoToHomePage();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks the Register link")
	public void the_user_clicks_the_register_link()
	{	
		try
		{
			homePage.ClickRegistrationLink();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}			
	}

	@Then("The user should be redirected to registration page.")
	public void the_user_should_be_redirected_to_registration_page() 
	{
		try
		{
			registerPage.VerifyRegistrationUrl();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}					
	}
	
	// Scenario1 @EmptyTextBoxGetRegister
	@Given("user is on registration page")
	public void user_is_on_registration_page() 
	{
		try
		{
			registerPage.VerifyRegistrationUrl();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}						
	}

	@When("user click register button with empty Unm and pwd textbox")
	public void user_click_register_button() 
	{
		try
		{
			registerPage.ClickRegistrationButton();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}					
	}

	@Then("warning message should display")
	public void warning_message_should_display()
	{
		try
		{
			registerPage.VerifyRegistrationUrl();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}						
	}

	@Then("Registration Status Success")
	public void registration_status_success() 
	{
		try
		{
			registerPage.RegistrationSuccess();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}								
	}

	@Then("Registration Status Fail")
	public void registration_status_fail()
	{
		try
		{
			registerPage.RegistrationFail();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}						
	}
	
	@Then("Registration Status Pass")
	public void registration_status_pass() 
	{
		try
		{
			registerPage.RegistrationSuccess();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}						
	}
	
	@When("user click login link to check successful registration")
	public void user_click_login_link_to_check_successful_registration()
	{
		try
		{
			registerPage.ClickLoginLink();
			registerPage.User71();
			registerPage.ClickLoginButton();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}						  
	}

	@When("user click NumpyNinja link.")
	public void user_click_numpy_ninja_link() 
	{
		try
		{
			registerPage.ClickNumpyNinjaLogo();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}							
	}

	@Then("user redirect to landing page")
	public void user_redirect_to_landing_page() 
	{
		try
		{
			registerPage.RedirectToLandingPage();
			registerPage.GoToHomePage();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}						
	}

	@When("user click sign in link.")
	public void user_click_sign_in_link() 
	{
		try
		{
			registerPage.ClickSignLink();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}								
	}
	
	@Then("user logged into website")
	public void user_redirect_to_login_page() 
	{
		try
		{
			registerPage.RedirectToLoginPage();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}						
	}
	
	@When("user enter userName from {string} and rownumber {int}")
	public void user_enter_user_name_from_and_rownumber(String sheetName, Integer rownumber) throws InvalidFormatException,IOException 
	{
		try
		{
			Map<String, String> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(sheetName).get(rownumber);
			registerPage.validateUser(testdata.get("UserName"),testdata.get("Password"),testdata.get("Confirmpwd"),testdata.get("Status"));
			//registerPage.ClickRegistrationButton();
			//errorMessage=testdata.get("expectedmessage");
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}					
	}

	@Then("verify Registration Status")
	public void registration_status()
	{	
		try
		{
			registerPage.ClickRegistrationButton();
			homePage.VerifyLoginSuccessMsg();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
}

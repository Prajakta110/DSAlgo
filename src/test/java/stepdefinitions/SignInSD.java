package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignInPage;
import utilities.HandleExceptions;
import utilities.Log;

public class SignInSD {
	
	TestContext testContext;
	
	HomePage homePage;
	SignInPage signinPage;
	RegisterPage registerPage;
	
	static String username;
	static String password;
	
	public SignInSD(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		registerPage = testContext.getPageObjectManager().getRegistrationPage();
	}	
	
	@Given("User is on DS Algo Home Page")
	public void user_is_on_ds_algo_home_page()
	{
	    try
	    {
	    	homePage.GoToHomePage();
	    }
	    catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@Given("User is on SignIn page")
	public void user_is_on_sign_in_page() {
		try
		{
			Log.startTestCase();
			homePage.GoToHomePage();
			homePage.ClickOnSignIn();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	@When("User Clicks on Register link")
	public void user_clicks_on_register_link() {
		try
		{
			signinPage.ClickOnRegister();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	   
	}
	@Then("User should be redirected to Register page")
	public void user_should_be_redirected_to_register_page() {
		try
		{
			registerPage.VerifyRegistrationUrl();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	@When("User clicks on login button with all empty field")
	public void user_clicks_on_login_button_with_all_empty_field() {
		try
		{
			Log.startTestCase();
			signinPage.ClickOnLogin();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	    
	}

	//review
	@Then("User verify the message at username as {string}")
	public void user_verify_the_message_at_username_as(String string) {
		try
		{
			String text= signinPage.ValidateUsernamefield(string);
			assertEquals(text,"Please fill out this field.");	
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	//review
	@When("User clicks on login button with username as {string} only")
	public void user_clicks_on_login_button_with_username_as_only(String numpy) {
		try
		{
		signinPage.EnterUserName(numpy);
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	    
	}

	//review
	@Then("User verify the message at password as {string}")
	public void user_verify_the_message_at_password_as(String numpy) {
		try
		{
			String text= signinPage.ValidatePasswordfield(numpy);
			assertEquals(text,"Please fill out this field.");
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on login button with password as {string} only")
	public void user_clicks_on_login_button_with_password_as_only(String string) {
		try
		{
			signinPage.EnterPassword(string);
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User verify the message at user as {string}")
	public void user_verify_the_message_at_user_as(String string) {
		try
		{
			String text= signinPage.ValidateUsernamefield(string);
			assertEquals(text,"Please fill out this field.");
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String username) {
		try
		{
			signinPage.EnterUserName(username);
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
		try
		{
			signinPage.EnterPassword(password);
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks login button")
	public void user_clicks_login_button() {
		try
		{
			signinPage.ClickOnLogin();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	//review
	@Then("User verify the message as {string}")
	public void user_verify_the_message_as(String string) {
		try
		{
			String alertmsg =signinPage.InvalidAlert();
			Log.info("The actual Alert is:" +alertmsg);
			assertEquals(alertmsg, string);
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}



	@When("User enters sheetname {string} and rownumber {int}")
	public void user_enters_sheetname_and_rownumber(String Sheetname, Integer RowNumber) {
		try
		{
			List<Map<String, String>> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(Sheetname);
			username = testdata.get(RowNumber).get("UserName");
			password = testdata.get(RowNumber).get("Password");
			
			Log.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");
			if (username != null || password != null)
				signinPage.EnterUserName(username);
			    signinPage.EnterPassword(password);
			
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		try
		{
			signinPage.ClickOnLogin();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	//review
	@Then("It should navigate to the home page with a message {string}")
	public void it_should_navigate_to_the_home_page_with_a_message(String string) {
		try
		{
			signinPage.SuccessAlert();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}


	@Then("User should be able to Sign out")
	public void user_should_be_able_to_sign_out()
	{
	    try
	    {
	    	homePage.VerifyLogoutSuccessMsg();
	    }
	    catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
}
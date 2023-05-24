package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import context.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.HomePage;
import pages.SignInPage;
import readers.ConfigFileReader;
import utilities.Log;
import utilities.Screenshots;
import utils.LoggerLoad;
import readers.ExcelReader;
public class SignInSD {
	
TestContext testContext;
	
	HomePage homePage;
	SignInPage signinPage;
	
	static String username;
	static String password;
	String Excelpath=ConfigFileReader.getExcelPath();
	
	public SignInSD(TestContext context)
	{
		
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		//SignInPage signIn = new SignInPage();
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
			HandleExceptions(ex);
		}
	}
//	@Given("User is logged in to the application")
//	public void u_ser_is_logged_in_to_the_application()
//	{
//	    try
//	    {
//	    	homePage.ClickOnSignIn();
//	    	signinPage.SignIn();
//	    	homePage.VerifySignedIn();
//	    }
//	    catch(Exception ex)
//		{
//			HandleExceptions(ex);
//		}
//	}
//	@When("User clicks on Sign Out button")
//	public void user_clicks_on_sign_out_button()
//	{
//	    try
//	    {
//	    	homePage.ClickOnSignOutBtn();
//	    }
//	    catch(Exception ex)
//		{
//			HandleExceptions(ex);
//		}
//	}
	
	@Given("User is on SignIn page")
	public void user_is_on_sign_in_page() {
		
		LoggerLoad.info("------User is On Sign in page------");
		signinPage.getLoginurl();    
	}
	@When("User Clicks on Register link")
	public void user_clicks_on_register_link() {
		LoggerLoad.info("----User Clicks on Register Link-----");
		signinPage.register();
	   
	}
	@Then("User should be redirected to Register page")
	public void user_should_be_redirected_to_register_page() {
		String title =signinPage.register_page();
		LoggerLoad.info("----User redirected to Page----"+title);
		assertEquals(title, "Registration");
	}
	@When("User clicks on login button with all empty field")
	public void user_clicks_on_login_button_with_all_empty_field() {
		
		 LoggerLoad.info("User is Clicking login button with empty fields");
		 signinPage.ClickOnLogin();
	    
	}

	@Then("User verify the message at username as {string}")
	public void user_verify_the_message_at_username_as(String string) {
		String text= signinPage.validateUsernamefield(string);
		assertEquals(text,"Please fill out this field.");	    
	}

	@When("User clicks on login button with username as {string} only")
	public void user_clicks_on_login_button_with_username_as_only(String numpy) {
		LoggerLoad.info("--User Enters Only the User name--");

		signinPage.EnterUserName(numpy);

	    
	}

	@Then("User verify the message at password as {string}")
	public void user_verify_the_message_at_password_as(String numpy) {
		
		String text= signinPage.validatePasswordfield(numpy);
		LoggerLoad.info("----User can see" +text +"-----");
		assertEquals(text,"Please fill out this field.");
	}

	@When("User clicks on login button with password as {string} only")
	public void user_clicks_on_login_button_with_password_as_only(String string) {
		LoggerLoad.info("User Enters Only Password");
		signinPage.EnterPassword(string);
	    
	}

	@Then("User verify the message at user as {string}")
	public void user_verify_the_message_at_user_as(String string) {
		
		String text= signinPage.validateUsernamefield(string);
		LoggerLoad.info("User can see" +text);
		assertEquals(text,"Please fill out this field.");
	   
	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String username) {
		
		signinPage.EnterUserName(username);
	    
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
		signinPage.EnterPassword(password);
	    
	}

	@When("User clicks login button")
	public void user_clicks_login_button() {
		
		LoggerLoad.info("-----User Clicks on Login button-----");
		
		signinPage.ClickOnLogin();
	    
	}
	@Then("User verify the message as {string}")
	public void user_verify_the_message_as(String string) {
		String alertmsg =signinPage.invalidAlert();
		LoggerLoad.info("The actual Alert is:" +alertmsg);
		assertEquals(alertmsg, string);

	}



	@When("User enters sheetname {string} and rownumber {int}")
	public void user_enters_sheetname_and_rownumber(String Sheetname, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.ReadExcelFile(Sheetname);
		username = testdata.get(RowNumber).get("username");
		password = testdata.get(RowNumber).get("password");


		
		
		LoggerLoad.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");
		if (username != null || password != null)
			signinPage.EnterUserName(username);
		    signinPage.EnterPassword(password);
		
	    
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		signinPage.ClickOnLogin();
	    
	}

	@Then("It should navigate to the home page with a message {string}")
	public void it_should_navigate_to_the_home_page_with_a_message(String string) {
		signinPage.successAlert();
	    
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
			HandleExceptions(ex);
		}
	}
	
	public void HandleExceptions(Exception ex)
	{
		Log.error(ex.getMessage());
		Log.endTestCase();
		Screenshots.CaptureScreenshot(testContext.getWebDriverManager().getDriver());
	}
	
}
package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignInPage;
import utilities.Log;
import utilities.Screenshots;

public class SignInSD {

	TestContext testContext;
	
	HomePage homePage;
	SignInPage signinPage;
	
	public SignInSD(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
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

	@Given("User is logged in to the application")
	public void u_ser_is_logged_in_to_the_application() 
	{
	    try
	    {
	    	homePage.ClickOnSignIn();
	    	signinPage.SignIn();
	    	homePage.VerifySignedIn();
	    }
	    catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}

	@When("User clicks on Sign Out button")
	public void user_clicks_on_sign_out_button() 
	{
	    try
	    {
	    	homePage.ClickOnSignOutBtn();
	    }
	    catch(Exception ex)
		{
			HandleExceptions(ex);
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

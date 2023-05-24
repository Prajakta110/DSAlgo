package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LandingPage;

public class LandingSD {

	TestContext testContext;
	
	HomePage homePage;
	LandingPage landingPage;
	
	public LandingSD(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		landingPage = testContext.getPageObjectManager().getLandingPage();
	}
	
	@Given("User is on DS algo landing page")
	public void i_am_on_ds_algo_landing_page() 
	{
	    landingPage.GoToLandingPage();
	}

	@When("User clicks on Get Started button on Landing Page")
	public void User_click_on_Get_started_button() {
		landingPage.ClickOnGetStarted();
	}
//	
//	
//	@Then("Verify Get Started button")
//	public void Verify_Get_Started_button() {
//	    homePage.VerifyGetStartedButton();
//	}

	@Then("User is navigated to DS algo home page")
	public void ds_algo_home_page_is_opened() 
	{
	    homePage.VerifyHomePageURL();
	}
}

package stepdefinitions;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignInPage;

public class HomeSD {
	
	WebDriver driver;
	
	HomePage homePage;
	RegisterPage registerPage;
	SignInPage signIn;
	
	TestContext testContext;
	
	public HomeSD(TestContext context)
	{
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();
		registerPage = testContext.getPageObjectManager().getRegistrationPage();
		signIn = testContext.getPageObjectManager().getSignInPage();
	}
	
	@Given("User is on DS algo home page")
	public void user_is_on_ds_algo_home_page() {
		homePage.GoToHomePage();
	}
	
	@Then("User Launches Home Page")
	public void user_home_page_is_opened() {
		homePage.GoToHomePage();
	}
	
	@Then("DS algo home page opened")
	public void Ds_algo_home_page_opened() {
	    homePage.VerifyHomePageURL();
	}
	
	@Then("Verify user is not logged in")
	public void erify_user_is_not_loggedin() {
	    homePage.VerifyNotSignedIn();
	}
		
	
//	@Then("Verify Get Started button")
//	public void Verify_Get_Started_button() {
//	    homePage.VerifyGetStartedButton();
//	}
	
	
	@When("User clicks on Register")
	public void User_clicks_on_Register() {
		homePage.ClickOnRegister();
	}

	@Then("User should be directed to Register page")
	public void User_should_be_directed_to_Registerpage() {
		registerPage.VerifyRegistrationUrl();
	}
	
	@When("User clicks on SignIn")
	public void User_clicks_on_SignIn() {
		homePage.ClickOnSignIn();
	}
	
	@Then("User should be directed to SignIn Page")
	public void User_should_be_directed_to_SignIn_Page() {
		signIn.VerifySignInPageURL();
	}
	
	@When("User Clicks on Data Structure Drop Down")
	public void User_Clicks_on_Data_Structure_Drop_Down() {
		homePage.ClickOnDataStructuresDropdown();
	}
	
	@Then("user should be able to view the Drop Down")
	public void user_should_be_able_to_view_the_Drop_Down() {
		homePage.ClickOnDataStructures();
	}
	
	@When("User Clicks on Data Structure-Introduction GetStartedBtn")
	public void User_Clicks_on_Data_Structure_Introduction_GetStartedBtn() {
		homePage.ClickOnDataStructures();
	}
	
	@Then("user should be able to view the error msg")
	public void user_should_be_able_to_view_the_error_msg() {
		homePage.VerifyLoginErrorMsg();
	}
	
	@When("User clicks on Array GetStartedBtn")
	public void User_clicks_on_Array_GetStartedBtn() {
		homePage.ClickOnArray();
	}
	@When("User clicks on LinkedList GetStartedBtn")
	public void User_clicks_on_LinkedList_GetStartedBtn() {
		homePage.ClickOnLinkedList();
	}

	@When("User clicks on Stack GetStartedBtn")
	public void User_clicks_on_Stack_GetStartedBtn() {
		homePage.ClickOnStack();
	}
	
	@When("User clicks on Queue GetStartedBtn")
	public void User_clicks_on_Queue_GetStartedBtn() {
		homePage.ClickOnQueue();
	}
	
	@When("User clicks on Tree GetStartedBtn")
	public void User_clicks_on_Tree_GetStartedBtn() {
		homePage.ClickOnTree();
	}
	
	@When("User clicks on Graph GetStartedBtn")
	public void User_clicks_on_Graph_GetStartedBtn() {
		homePage.ClickOnGraph();
	}

	public static void click() {
		// TODO Auto-generated method stub
		
	}

	public static void clickongetstartedbutton() {
		// TODO Auto-generated method stub
			
	}
	
	@When("^User clicks on HomePage DataStructure \"(.*)\"")
	public void user_clicks_on_Homepage_DataStructure_linkname(String linkname) {
		homePage.ClickonDataStructureLinkname(linkname);
	}
	
	@When("^User clicks on HomePage DataStructure DropDown \"(.*)\"")
	public void user_clicks_on_Homepage_DataStructure_DropDown_linkname(String linkname) {
		homePage.ClickonDataStructureDropDown(linkname);
	}

}
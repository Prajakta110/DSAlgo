package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignInPage;
import utilities.HandleExceptions;
import utilities.Log;

public class HomeSD {

	TestContext testContext;
	
	HomePage homePage;
	RegisterPage registerPage;
	SignInPage signIn;

	public HomeSD(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		registerPage = testContext.getPageObjectManager().getRegistrationPage();
		signIn = testContext.getPageObjectManager().getSignInPage();
	}

	@Given("User is on DS algo home page")
	public void user_is_on_ds_algo_home_page() {
		try {
			Log.startTestCase();
			homePage.GoToHomePage();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User Launches Home Page")
	public void user_home_page_is_opened() {
		try {
			homePage.GoToHomePage();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("DS algo home page opened")
	public void Ds_algo_home_page_opened() {
		try {
			homePage.VerifyHomePageURL();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("Verify user is not logged in")
	public void erify_user_is_not_loggedin() {
		try {
			homePage.VerifyNotSignedIn();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Register")
	public void User_clicks_on_Register() {
		try {
			homePage.ClickOnRegister();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be directed to Register page")
	public void User_should_be_directed_to_Registerpage() {
		try {
			registerPage.VerifyRegistrationUrl();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on SignIn")
	public void User_clicks_on_SignIn() {
		try {
			homePage.ClickOnSignIn();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be directed to SignIn Page")
	public void User_should_be_directed_to_SignIn_Page() {
		try {
			signIn.VerifySignInPageURL();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User Clicks on Data Structure Drop Down")
	public void User_Clicks_on_Data_Structure_Drop_Down() {
		try {
			homePage.ClickOnDataStructuresDropdown();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("user should be able to view the Drop Down")
	public void user_should_be_able_to_view_the_Drop_Down() {
		try {
			homePage.ClickOnDataStructures();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User Clicks on Data Structure-Introduction GetStartedBtn")
	public void User_Clicks_on_Data_Structure_Introduction_GetStartedBtn() {
		try {
			homePage.ClickOnDataStructures();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("user should be able to view the error msg")
	public void user_should_be_able_to_view_the_error_msg() {
		try {
			homePage.VerifyLoginErrorMsg();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Array GetStartedBtn")
	public void User_clicks_on_Array_GetStartedBtn() {
		try {
			homePage.ClickOnArray();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on LinkedList GetStartedBtn")
	public void User_clicks_on_LinkedList_GetStartedBtn() {
		try {
			homePage.ClickOnLinkedList();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Stack GetStartedBtn")
	public void User_clicks_on_Stack_GetStartedBtn() {
		try {
			homePage.ClickOnStack();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Queue GetStartedBtn")
	public void User_clicks_on_Queue_GetStartedBtn() {
		try {
			homePage.ClickOnQueue();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Tree GetStartedBtn")
	public void User_clicks_on_Tree_GetStartedBtn() {
		try {
			homePage.ClickOnTree();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Graph GetStartedBtn")
	public void User_clicks_on_Graph_GetStartedBtn() {
		try {
			homePage.ClickOnGraph();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("^User clicks on HomePage DataStructure \"(.*)\"")
	public void user_clicks_on_Homepage_DataStructure_linkname(String linkname) {
		try {
			homePage.ClickonDataStructureLinkname(linkname);
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("^User clicks on HomePage DataStructure DropDown \"(.*)\"")
	public void user_clicks_on_Homepage_DataStructure_DropDown_linkname(String linkname) {
		try {
			homePage.ClickonDataStructureDropDown(linkname);
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

}
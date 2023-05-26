package stepdefinitions;

import java.util.Map;
import enums.Context;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.EditorPage;
import pages.HomePage;
import pages.PracticePage;
import pages.SignInPage;
import pages.StackPage;
import utilities.HandleExceptions;
import utilities.Log;

public class StackSD {

	TestContext testContext;
	HomePage homePage;
	SignInPage signinPage;
	StackPage stackPage;
	EditorPage editorPage;
	PracticePage practicePage;

	public StackSD(TestContext context) 
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		editorPage = testContext.getPageObjectManager().getEditorPage();
		stackPage = testContext.getPageObjectManager().getStackPage();
		practicePage = testContext.getPageObjectManager().getPracticePage();
	}

	@Given("User is on DS Home page")
	public void user_is_on_ds_algo_home_page() 
	{
		try 
		{
			Log.startTestCase();
			homePage.GoToHomePage();
		} 
		catch (Exception ex) 
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Signin button on Home page")
	public void user_clicks_on_sign_in_button_on_home_page() {
		try {
			homePage.ClickOnSignIn();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User enters valid username and pwd")
	public void user_enters_valid_username_and_password() {
		try {
			signinPage.EnterUserName(FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
			signinPage.EnterPassword(FileReaderManager.getInstance().getConfigReader().getDSAlgoPassword());
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Signin")
	public void user_clicks_on_sign_in() {
		try {
			signinPage.ClickOnLogin();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User clicks on Get Started button for Stack")
	public void user_clicks_on_get_started_button_for_stack() {
		try {
			homePage.ClickOnStack();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be redirected to Stack page")
	public void user_should_be_redirected_to_stack_page() {
		try {
			stackPage.NavigateTOStackPage();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Given("User is on Stack page")
	public void user_is_on_stack_page() {
		try {
			homePage.ClickOnStack();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Operations in Stack link")
	public void user_clicks_on_operations_in_stack_link() {
		try {
			stackPage.ClickOperationLink();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be redirected to Opeartions in Stack page")
	public void user_should_be_redirected_to_opeartions_in_stack_page() {
		try {
			stackPage.NavigateToOperationPage();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}

	}

	@Given("User is on Operations-in-stack page")
	public void user_is_on_operations_in_stack_page() {
		try {
			homePage.ClickOnStack();
			stackPage.ClickOperationLink();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on implementation link")
	public void user_clicks_on_implementation_link() {
		try {
			stackPage.ClickImplementationLink();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}

	}

	@Then("User should redirect to implementation page")
	public void user_should_redirect_to_implementation_page() {
		try {
			stackPage.NavigateToImplementationPage();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Given("User is on  implentation page")
	public void user_is_on_implentation_page() {
		try {
			homePage.ClickOnStack();
			stackPage.ClickImplementationLink();
		}

		catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}

	}

	@When("User clicks Application link")
	public void user_clicks_application_link() {
		try {
			stackPage.ClickApplicationsLink();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should redirect to Application page")
	public void user_should_redirect_to_application_page() {
		try {
			stackPage.NavigateToApplicationsPage();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Given("User is on Application page")
	public void user_is_on_application_page() {
		try {
			homePage.ClickOnStack();
			stackPage.ClickApplicationsLink();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User Clicks on Try here>>>")
	public void user_clicks_on_try_here() {
		try {
			stackPage.TryHereButton();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should navigate to tryEditor Page")
	public void user_should_navigate_to_try_editor_page() {
		try {
			stackPage.NavigateToTryHerePage();
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	// Scenario outline
	@Given("User is on tryEditor page")
	public void user_is_on_try_editor_page() {
		try {
			homePage.ClickOnStack();
			stackPage.ClickApplicationsLink();
			stackPage.TryHereButton();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User Clicks Run button")
	public void user_clicks_run_button() {
		try {
			editorPage.ClickOnRun();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User runs python code from {string} rownumber {int}")
	public void user_runs_python_code_from_rownumber(String sheetName, Integer rownumber)
	{
		try {
			Map<String, String> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(sheetName).get(rownumber);
			editorPage.RunCodeInTryEditor(testdata.get("Code"));
			testContext.scenarioContext.setContext(Context.RunOutput, testdata.get("Result"));
		} 
		catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should get correct output.")
	public void user_should_get_correct_output() {
		try {
			editorPage.VerifyOutput((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}
	
	@Then("User should get correct error message.")
	public void user_should_get_correct_error_message() {
		try {
			editorPage.VerifyErrorMessage((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}
}
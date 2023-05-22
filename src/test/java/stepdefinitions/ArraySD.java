package stepdefinitions;

import java.util.Map;

import context.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.ArrayPage;
import pages.EditorPage;
import pages.HomePage;
import pages.PracticePage;
import pages.SignInPage;
import utilities.HandleExceptions;
import utilities.Log;

public class ArraySD {

	TestContext testContext;
	
	HomePage homePage;
	SignInPage signinPage;
	ArrayPage arrayPage;
	EditorPage editorPage;
	PracticePage practicePage;
	String output;
	
	public ArraySD(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		arrayPage = testContext.getPageObjectManager().getArrayPage();
		editorPage = testContext.getPageObjectManager().getEditorPage();
		practicePage = testContext.getPageObjectManager().getPracticePage();
	}
	
	@Given("User is on DS Algo Home page")
	public void user_is_on_ds_algo_home_page() 
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
	
	@When("User clicks on Sign in button on Home page")
	public void user_clicks_on_sign_in_button_on_home_page() 
	{
		try
		{
			homePage.ClickOnSignIn();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() 
	{
		try
		{
			signinPage.EnterUserName(FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
			signinPage.EnterPassword(FileReaderManager.getInstance().getConfigReader().getDSAlgoPassword());
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@When("User clicks on Sign in")
	public void user_clicks_on_sign_in() 
	{
		try
		{
			signinPage.ClickOnLogin();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User shoild be able to see the logged in message")
	public void user_shoild_be_able_to_see_the_logged_in_message() 
	{
		try
		{
			homePage.VerifyLoginSuccessMsg();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	//1
	@When("User clicks on Get Started button for Array")
	public void user_clicks_on_get_started_button_for_array() 
	{
		try
		{
			homePage.ClickOnArray();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be redirected to Array page")
	public void user_should_be_redirected_to_array_page() 
	{
		try
		{
			arrayPage.VerifyArrayPage();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@Given("User is on Array page")
	public void user_is_on_array_page() 
	{
		try
		{
			homePage.ClickOnArray();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Arrays in Python link")
	public void user_clicks_on_arrays_in_python_link()
	{
		try
		{
			arrayPage.ClickOnArraysInPython();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be redirected to Arrays in Python page")
	public void user_should_be_redirected_to_arrays_in_python_page() 
	{
		try
		{
			arrayPage.VerifyArraysinPythonPage();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Given("User is on Arrays in Python page")
	public void user_is_on_arrays_in_python_page() 
	{
		try
		{
			homePage.ClickOnArray();
			arrayPage.ClickOnArraysInPython();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Try Here button")
	public void user_clicks_on_try_here_button() 
	{
		try
		{
			arrayPage.ClickOnTryEditor();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be redirected to Editor page")
	public void user_should_be_redirected_to_editor_page() 
	{
		try
		{
			arrayPage.VerifyTryEditorPage();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@Given("User is on Editor Page")
	public void user_is_on_editor_page() 
	{
		try
		{
			homePage.ClickOnArray();
			arrayPage.ClickOnArraysInPython();
			arrayPage.ClickOnTryEditor();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@When("User runs a python code from {string} row number {int}")
	public void user_runs_a_python_code_from_row_number(String string, Integer int1)  
	{
		try
		{
			Map<String, String> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(string).get(int1);
			editorPage.RunCodeInTryEditor(testdata.get("Code"));
			testContext.scenarioContext.setContext(Context.RunOutput, testdata.get("Result"));
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}


	@Then("User should be able to see the correct output")
	public void user_should_be_able_to_see_the_correct_output() 
	{
		try
		{
			editorPage.VerifyOutput((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be able to see relevant error message")
	public void user_should_be_able_to_see_relevant_error_message() 
	{
		try
		{
			editorPage.VerifyErrorMessage((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on Practice Questions link")
	public void user_clicks_on_practice_questions_link() 
	{
		try
		{
			arrayPage.ClickOnPracticeQuestionsLink();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be redirected to Practice page")
	public void user_should_be_redirected_to_practice_page() 
	{
		try
		{
			arrayPage.VerifyPracticePage();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@Given("User is on Practice Questions Page")
	public void user_is_on_practice_questions_page() 
	{
		try
		{
			homePage.ClickOnArray();
			arrayPage.ClickOnArraysInPython();
			arrayPage.ClickOnPracticeQuestionsLink();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User clicks on first Question link")
	public void user_clicks_on_first_question_link() 
	{
		try
		{
			practicePage.ClickOnFirstQuestion();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be redirected to Question page with the editor")
	public void user_should_be_redirected_to_question_page_with_the_editor() 
	{
		try
		{
			practicePage.VerifyQuestionPageOpened();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@Given("User is on Question Page")
	public void user_is_on_question_page() 
	{
		try
		{
			homePage.ClickOnArray();
			arrayPage.ClickOnArraysInPython();
			arrayPage.ClickOnPracticeQuestionsLink();
			practicePage.ClickOnFirstQuestion();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User runs a relevant python code from {string} row number {int}")
	public void user_runs_a_relevant_python_code_from_row_number(String string, Integer int1) 
	{
		try
		{
			Map<String, String> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(string).get(int1);
			editorPage.RunCodeInTryEditor(testdata.get("Code"));
			testContext.scenarioContext.setContext(Context.RunOutput, testdata.get("Result"));
			testContext.scenarioContext.setContext(Context.SubmitOutput, testdata.get("submitResult"));
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be able to get correct output")
	public void user_should_be_able_to_get_correct_output() 
	{
		try
		{
			editorPage.VerifyOutput((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be able to submit the code")
	public void user_should_be_able_to_submit_the_code() 
	{
		try
		{
			editorPage.ClickOnSubmit();
			editorPage.VerifyOutput((String)testContext.scenarioContext.getContext(Context.SubmitOutput));
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@When("User runs code with error from {string} row number {int}")
	public void user_runs_code_with_error_from_row_number(String string, Integer int1)
	{
		try
		{
			Map<String, String> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(string).get(int1);
			editorPage.RunCodeInTryEditor(testdata.get("Code"));
			testContext.scenarioContext.setContext(Context.RunOutput, testdata.get("Result"));
			testContext.scenarioContext.setContext(Context.SubmitOutput, testdata.get("submitResult"));
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be able to get relevant error message")
	public void user_should_be_able_to_get_relevant_error_message() 
	{
		try
		{
			editorPage.VerifyErrorMessage((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User should be able to get error on submitting the invalid code")
	public void user_should_be_able_to_get_error_on_submitting_the_invalid_code() 
	{
		try
		{
			editorPage.ClickOnSubmit();
			editorPage.VerifyOutput((String)testContext.scenarioContext.getContext(Context.SubmitOutput));
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
		
	}
}

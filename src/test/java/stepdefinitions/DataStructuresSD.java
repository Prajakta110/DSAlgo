package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import context.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.*;
import utilities.Log;
import utilities.Screenshots;

public class DataStructuresSD {

	TestContext testContext;
	
	DataStructuresPage dataStructuresPage;
	HomePage homePage;
	SignInPage signinPage;
	EditorPage editorPage;
	
	public DataStructuresSD(TestContext context)
	{
		testContext = context;
		dataStructuresPage = testContext.getPageObjectManager().getDataStructuresPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		editorPage = testContext.getPageObjectManager().getEditorPage();
	}
	
	//Scenario01
	@When("User clicks on Get Started button for Data Structures")
	public void user_clicks_on_get_started_button_for_data_structures() 
	{
		try
		{
			homePage.ClickOnDataStructures();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}

	@Then("User should be redirected to Data Structures page")
	public void user_should_be_redirected_to_data_structures_page() 
	{
		try
		{
			dataStructuresPage.VerifyDataStructuresPage();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}
	
	//Scenario02
	@Given("User is on Data Structures page")
	public void user_is_on_data_structures_page() 
	{
		try
		{
			homePage.ClickOnDataStructures();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}

	@When("User clicks on Time Complexity link")
	public void user_clicks_on_time_complexity_link() 
	{
		try
		{
			dataStructuresPage.ClickOnTimeComplexity();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}

	@Then("User should be redirected to Time Complexity Page")
	public void user_should_be_redirected_to_time_complexity_page() 
	{
		try
		{
			dataStructuresPage.VerifyTimeComplexityPage();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}
	
	//Scenario03
	@Given("User is on Time Complexity page")
	public void user_is_on_time_complexity_page() 
	{
		try
		{
			homePage.ClickOnDataStructures();
			dataStructuresPage.ClickOnTimeComplexity();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}

	@When("User clicks on Try here button")
	public void user_clicks_on_try_here_button() 
	{
		try
		{
			dataStructuresPage.ClickOnTryEditor();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}

	@Then("User should be redirected to Editor Page")
	public void user_should_be_redirected_to_editor_page() 
	{
		try
		{
			editorPage.VerifyTryEditorPage();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}

	//DSEditor01
	@Given("User is on Editor page")
	public void user_is_on_editor_page() 
	{
		try
		{
			homePage.ClickOnDataStructures();
			dataStructuresPage.ClickOnTimeComplexity();
			dataStructuresPage.ClickOnTryEditor();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}
	
	@When("User runs python code from {string} row number {int}")
	public void user_runs_python_code_from_sheet_row_number(String string, Integer int1) throws InvalidFormatException, IOException 
	{
		try
		{
			Map<String, String> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(string).get(int1);
			editorPage.RunCodeInTryEditor(testdata.get("Code"));
			testContext.scenarioContext.setContext(Context.RunOutput, testdata.get("Result"));
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}
	
	@Then("User should be able to see correct output")
	public void user_should_be_able_to_see_correct_output() 
	{
		try
		{
			editorPage.VerifyOutput((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions(ex);
		}
	}

	@Then("User should be able to see correct error message")
	public void user_should_be_able_to_see_correct_error_message() 
	{
		try
		{
			editorPage.VerifyErrorMessage((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
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

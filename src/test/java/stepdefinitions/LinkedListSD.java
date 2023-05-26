package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.LinkedListPage;
import utilities.HandleExceptions;
import utilities.Log;
import pages.EditorPage;
import pages.HomePage;

public class LinkedListSD {
	
	TestContext testContext;
	WebDriver driver;
	
	LinkedListPage linkedListPage;
	EditorPage editorPage;
	HomePage homePage;
	
	public LinkedListSD(TestContext context)
	{
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		linkedListPage = testContext.getPageObjectManager().getLinkedListPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		editorPage = testContext.getPageObjectManager().getEditorPage();
	}
	
	@When("Verify User is on Linked List Page")
	public void verify_user_is_on_linked_list_page() {
		try
		{
			linkedListPage.VerifyLinkedlistUrl();
			Log.endTestCase();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@Given("User is on Editor page via {string} and {string}")
	public void user_is_on_editor_page_via_link_and_url(String string, String string2) {
		try
		{
			homePage.ClickOnLinkedList();
			linkedListPage.LinkedlistClickOnLink(string);
			linkedListPage.VerifyLinkedlistChildUrl(string2);
			linkedListPage.ClickOnTryHereBtn();
			editorPage.VerifyTryEditorPage();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}
	
	@When("User runs python code from {string} and row number {int}")
	public void user_runs_python_code_from_and_row_number(String string, Integer int1)  
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
	
	@Then("User should see the correct output")
	public void user_should_see_the_correct_output() 
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
	
	@Then("User should see the correct error message")
	public void user_should_see_correct_error_message() 
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
	
	
}




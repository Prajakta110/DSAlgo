package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import enums.Context;
import pages.SignInPage;
import pages.HomePage;
import pages.TreePage;
import pages.EditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import utilities.HandleExceptions;
import utilities.Log;


public class TreeSD {

	WebDriver driver;
	
	SignInPage signinPage;
	HomePage homePage;
	TestContext testContext;
	TreePage treePage;
	EditorPage editorPage;
	static String Tittle;

	public TreeSD(TestContext context) {

		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		treePage = testContext.getPageObjectManager().getTreePage();
		editorPage = testContext.getPageObjectManager().getEditorPage();
		driver = testContext.getWebDriverManager().getDriver();
	}

	@When("User click on the Tree Get Started button")
	public void user_click_on_the_tree_get_started_button() {
		try
		{
			homePage.ClickOnTree();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User is on Tree page and verify tittle as {string}")
	public void user_is_on_tree_page_and_verify_tittle_as(String msg) {
		try
		{
			Log.info("Tittle of the Tree page:  " + driver.getTitle());
			String Msg1 = driver.getTitle();
			assertEquals(Msg1, msg);
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Overview of Trees link")
	public void the_user_clicks_on_the_overview_of_trees_link() {
		try
		{
			treePage.ClickOverview();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("The user should be directed to the {string}  Page")
	public void the_user_should_be_directed_to_the_page(String PageName) {
		try
		{
			Tittle = driver.getTitle();
			assertEquals(Tittle, PageName);
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("The user should be redirected to tryEditor page with Run button")
	public void the_user_should_be_redirected_to_try_editor_page_with_run_button() {
		try
		{
			Tittle = driver.getTitle();
			System.out.println(Tittle);
			assertEquals(Tittle, "Assessment");
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Terminologies button")
	public void the_user_clicks_on_the_terminologies_button() {
		try
		{
			treePage.ClickTerminology();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks {string} button on {string} page")
	public void the_user_clicks_button_on_page(String trybutton, String pgName) {
		try
		{
		Log.info("User Clicks on " + trybutton + " in a " + pgName + " page");
		treePage.ClickTryhereLink();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Types of Trees button")
	public void the_user_clicks_on_the_types_of_trees_button() {
		try
		{
			treePage.ClickTypesOFTree();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Given("The user is on the {string} page")
	public void the_user_is_on_the_page(String pagename) {
		try
		{
			String page_name = pagename.replaceAll("\\s+", "");
			String URL = FileReaderManager.getInstance().getConfigReader().geturl(page_name);
	
			System.out.println(URL);
			driver.get(URL);
			Tittle = driver.getTitle();
			assertEquals(Tittle, pagename);
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Tree Traversals button")
	public void the_user_clicks_on_the_tree_traversals_button() {
		try
		{
			treePage.ClickTreeTraversal();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Traversal illustration button")
	public void the_user_clicks_on_the_traversal_illustration_button() {
		try
		{
			treePage.ClickTraveIllustrate();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the binary trees button")
	public void the_user_clicks_on_the_binary_trees_button() {
		try
		{
			treePage.ClickBinaryTree();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the types of binary trees button")
	public void the_user_clicks_on_the_types_of_binary_trees_button() {
		try
		{
			treePage.ClickTypesOfBinary();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Implementation in Python button")
	public void the_user_clicks_on_the_implementation_in_python_button() {
		try
		{
			treePage.ClickImplementPython();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the binary tree traversals button")
	public void the_user_clicks_on_the_binary_tree_traversals_button() {
		try
		{
			treePage.ClickBTTraverse();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Implementation of Binary Trees button")
	public void the_user_clicks_on_the_implementation_of_binary_trees_button() {
		try
		{
			treePage.ClickImplementBT();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Applications of Binary Trees button")
	public void the_user_clicks_on_the_applications_of_binary_trees_button() {
		try
		{
			treePage.ClickAppsOfBT();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Binary Search Trees button")
	public void the_user_clicks_on_the_binary_search_trees_button() {
		try
		{
			treePage.ClickBinarySearchTree();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Implementation of BST button")
	public void the_user_clicks_on_the_implementation_of_bst_button() {
		try
		{
			treePage.ClickImplementBST();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Given("The User is on try editor page with run button")
	public void the_user_is_on_try_editor_page_with_run_button() {
		try
		{
			driver.get(FileReaderManager.getInstance().getConfigReader().getEditorPageUrl());
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@When("User enter the Python code from sheet {string} rownumber {int}")
	public void user_enter_the_python_code(String sheetName, Integer rownumber) {
		try {
			Map<String, String> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(sheetName).get(rownumber);
			editorPage.RunCodeInTryEditor(testdata.get("Code"));
			testContext.scenarioContext.setContext(Context.RunOutput, testdata.get("Result"));
		} 
		catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User Verify the Result")
	public void user_verify_the_result() {
		try {
			editorPage.VerifyOutput((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("User enter the invalid Python code from sheet {string} rownumber {int}")
	public void user_enter_the_invalid_python_code(String sheetName, Integer rownumber) {
		try
		{
			Map<String, String> testdata = FileReaderManager.getInstance().getExcelReader().ReadExcelFile(sheetName).get(rownumber);
			editorPage.RunCodeInTryEditor(testdata.get("Code"));
			testContext.scenarioContext.setContext(Context.RunOutput, testdata.get("Result"));
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("User Verify the error message")
	public void user_verify_the_error_message() {
		try {
			editorPage.VerifyErrorMessage((String)testContext.scenarioContext.getContext(Context.RunOutput));
			Log.endTestCase();
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@When("The user clicks on the Practice Questions in Overview of Trees")
	public void the_user_clicks_on_the_practice_questions_in_overview_of_trees() {
		try
		{
			treePage.ClickPractQuesLink();
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

	@Then("The user should be directed to Practice Questions of tree page Page")
	public void the_user_should_be_directed_to_practice_questions_of_tree_page_page() {
		try
		{
			Tittle = driver.getTitle();
			System.out.println(Tittle);
			assertEquals(Tittle, "Practice Questions");
		}
		catch(Exception ex)
		{
			HandleExceptions.Handle(ex);
		}
	}

}

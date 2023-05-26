package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import pages.SignInPage;
import pages.HomePage;
import pages.TreePage;
import pages.EditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import readers.ConfigFileReader;
import managers.FileReaderManager;
import utilities.Log;


public class TreeSD {

	WebDriver driver;
	
	SignInPage signinPage;
	HomePage homePage;
	TestContext testContext;
	TreePage treePage;
	EditorPage editorPage;

	public TreeSD(TestContext context) {

		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		treePage = testContext.getPageObjectManager().getTreePage();
		editorPage = testContext.getPageObjectManager().getEditorPage();
		driver = testContext.getWebDriverManager().getDriver();
	}

	static String username;
	static String password;
	// TreePage tp = new TreePage();

	ConfigFileReader cr = new ConfigFileReader();
	static String Tittle;

//	public String getTitleofPage() {
//		String title=driver.getTitle();
//		return title;
//	}

	@Given("The user is on Signin page of DS Algo portal")
	public void the_user_is_on_signin_page_of_ds_algo_portal() {
		Log.info("------User is On Sign in page------");
		signinPage.GetLoginurl();
	}

	@When("The user enter valid {string} and {string}")
	public void the_user_enter_valid_and(String string, String string2) {
		Log.info("--User Enters valid User name and the Password--");

		signinPage.EnterUserName("sonali");
		signinPage.EnterPassword("Dsalgo@1");
	}

	@When("The user click on login button")
	public void the_user_click_on_login_button() {
		Log.info("-----User Clicks on Login button-----");

		signinPage.ClickOnLogin();

	}

	@Then("The user redirected to homepage")
	public void the_user_redirected_to_homepage() {
		// String title=homePage.getTitleofPage();
		// homePage.GoToHomePage();
		homePage.VerifyHomePageURL();
//		LoggerLoad.info("----User is on"+title +"Page----");
//		assertEquals(title,"NumpyNinja");
	}
//		public String register_page() {
//			String title = driver.getTitle();
//			return title;
//		}

	@When("User click on the Tree Get Started button")
	public void user_click_on_the_tree_get_started_button() {
		// System.out.println("test driver " +driver);
		treePage.ClickTreeGS();
	}

	@Then("User is on Tree page and verify tittle as {string}")
	public void user_is_on_tree_page_and_verify_tittle_as(String msg) {
		Log.info("Tittle of the Tree page:  " + driver.getTitle());
		String Msg1 = driver.getTitle();
		assertEquals(Msg1, msg);
	}

	@When("The user clicks on the Overview of Trees link")
	public void the_user_clicks_on_the_overview_of_trees_link() {
		treePage.ClickOverview();
	}

	@Then("The user should be directed to the {string}  Page")
	public void the_user_should_be_directed_to_the_page(String PageName) {
		Tittle = driver.getTitle();
		assertEquals(Tittle, PageName);
	}

	@Then("The user should be redirected to tryEditor page with Run button")
	public void the_user_should_be_redirected_to_try_editor_page_with_run_button() {
		Tittle = driver.getTitle();
		System.out.println(Tittle);
		assertEquals(Tittle, "Assessment");
	}

	@When("The user clicks on the Terminologies button")
	public void the_user_clicks_on_the_terminologies_button() {
		treePage.ClickTerminology();
	}

	@When("The user clicks {string} button on {string} page")
	public void the_user_clicks_button_on_page(String trybutton, String pgName) {
		Log.info("User Clicks on " + trybutton + " in a " + pgName + " page");
		treePage.ClickTryhereLink();
	}

	@When("The user clicks on the Types of Trees button")
	public void the_user_clicks_on_the_types_of_trees_button() {
		treePage.ClickTypesOFTree();
	}

	@Given("The user is on the {string} page")
	public void the_user_is_on_the_page(String pagename) {

		String page_name = pagename.replaceAll("\\s+", "");
		String URL = FileReaderManager.getInstance().getConfigReader().geturl(page_name);

		System.out.println(URL);
		driver.get(URL);
		Tittle = driver.getTitle();
		assertEquals(Tittle, pagename);
	}

	@When("The user clicks on the Tree Traversals button")
	public void the_user_clicks_on_the_tree_traversals_button() {
		treePage.ClickTreeTraversal();
	}

	@When("The user clicks on the Traversal illustration button")
	public void the_user_clicks_on_the_traversal_illustration_button() {
		treePage.ClickTraveIllustrate();
	}

	@When("The user clicks on the binary trees button")
	public void the_user_clicks_on_the_binary_trees_button() {
		treePage.ClickBinaryTree();
	}

	@When("The user clicks on the types of binary trees button")
	public void the_user_clicks_on_the_types_of_binary_trees_button() {
		treePage.ClickTypesOfBinary();
	}

	@When("The user clicks on the Implementation in Python button")
	public void the_user_clicks_on_the_implementation_in_python_button() {
		treePage.ClickImplementPython();
	}

	@When("The user clicks on the binary tree traversals button")
	public void the_user_clicks_on_the_binary_tree_traversals_button() {
		treePage.ClickBTTraverse();
	}

	@When("The user clicks on the Implementation of Binary Trees button")
	public void the_user_clicks_on_the_implementation_of_binary_trees_button() {
		treePage.ClickImplementBT();
	}

	@When("The user clicks on the Applications of Binary Trees button")
	public void the_user_clicks_on_the_applications_of_binary_trees_button() {
		treePage.ClickAppsOfBT();
	}

	@When("The user clicks on the Binary Search Trees button")
	public void the_user_clicks_on_the_binary_search_trees_button() {
		treePage.ClickBinarySearchTree();
	}

	@When("The user clicks on the Implementation of BST button")
	public void the_user_clicks_on_the_implementation_of_bst_button() {
		treePage.ClickImplementBST();
	}

	@Given("The User is on try editor page with run button")
	public void the_user_is_on_try_editor_page_with_run_button() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getEditorPageUrl());
	}

	@When("User enter the Python code")
	public void user_enter_the_python_code(io.cucumber.datatable.DataTable pythonCode) throws InterruptedException {
		List<List<String>> data = pythonCode.cells();
		editorPage.EnterCode(data.get(0).get(0));
	}

	@When("User Clicks on Run button")
	public void user_clicks_on_run_button() throws InterruptedException {
		editorPage.ClickOnRun();

	}

	@Then("User Verify the Result")
	public void user_verify_the_result() {
		String Reslt = treePage.getOutput();
		assertEquals(Reslt, "Hello Numpy Ninjas");
	}

	@When("User enter the invalid Python code")
	public void user_enter_the_invalid_python_code(io.cucumber.datatable.DataTable pythonCode)
			throws InterruptedException {
		List<List<String>> data = pythonCode.cells();
		treePage.enterCode(data.get(0).get(0));
	}

	@Then("User Verify the error message")
	public void user_verify_the_error_message() {
		String actualMsg = treePage.getErrormsg();
		Log.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg, "SyntaxError: bad input on line 1", "Result do not match");
	}

	@When("The user clicks on the Practice Questions in Overview of Trees")
	public void the_user_clicks_on_the_practice_questions_in_overview_of_trees() {
		treePage.ClickPractQuesLink();
	}

	@Then("The user should be directed to Practice Questions of tree page Page")
	public void the_user_should_be_directed_to_practice_questions_of_tree_page_page() {
		Tittle = driver.getTitle();
		System.out.println(Tittle);
		assertEquals(Tittle, "Practice Questions");
	}

}

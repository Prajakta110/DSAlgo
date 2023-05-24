package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import managers.FileReaderManager;
import utilities.Log;
import org.openqa.selenium.interactions.Actions;

public class StackPage {
	WebDriver driver;
	StackPage stackpage;
	Actions action;

	@FindBy(xpath = "//button[@class='btn']") WebElement getStartedButton;
	@FindBy(linkText = "Sign in") WebElement signInLink;
	@FindBy(name = "username") WebElement userNametextBox;
	@FindBy(xpath = "//*[@id=\"id_password\"]") WebElement loginpagepasswordtextBox;
	@FindBy(xpath = "//input[@type='submit']") WebElement loginButton;
	@FindBy(xpath = "//a[@href='stack']") WebElement stackGetStartedButton;
	@FindBy(xpath = "//a[@href='operations-in-stack']") WebElement operationLink;
	@FindBy(linkText = "Implementation") WebElement implementationLink;
	@FindBy(linkText = "Applications") WebElement applicationsLink;
	@FindBy(linkText = "Try here>>>") WebElement tryHereButton;
	// @FindBy(xpath="//textarea[@id='editor']")WebElement textEditor;
	@FindBy(xpath = "//div[@class='CodeMirror-lines']") WebElement textEditor;
	// By textEditor = By.xpath("//div[@class='CodeMirror-lines']");
	@FindBy(xpath = "//button[@type='button']") WebElement runButton;

	// Initialize Driver
	public StackPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Log.info("Get First Information");
	}

	// Open Ds-Algo Application
	public void DSAppPage() {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Log.info("User successfully opened DS-algo app");
		// driver.get("https://dsportalapp.herokuapp.com");
	}

	// Click get started button
	public void GetStartedButtonClick() {
		getStartedButton.click();
		Log.info("User clicked on get started button");
	}

	// Click sign in link from DsApp home page.
	public void ClickSignLink() {
		signInLink.click();
		Log.info("User clicked Signin link");
	}

	// Enter registered user name and password.
	public void User71Stack() {
		userNametextBox.sendKeys("User7");
		loginpagepasswordtextBox.sendKeys("Test1177");
		Log.info("User enterd User name and password");
	}

	// Click login button
	public void ClickLoginButton() {
		loginButton.click();
		Log.info("User clicked on login button");
	}

	// Click Get started button for Stack
	public void ClickGetStartedButtonForStack() {
		stackGetStartedButton.click();
		Log.info("User clicked on get started button");
	}

	// Navigate to Stack Page
	public void NavigateTOStackPage() {
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getStackUrl());
		Log.info("Verifies that user is on Stack Page");
	}

	public void VerifyStackPage() {
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getStackUrl());
		Log.info("Verifies that user is on Stack Page");
	}

	public void ClickOperationLink() {
		operationLink.click();
		Log.info("User clicked on operation link");
	}

	public void NavigateToOperationPage() {
		Assert.assertEquals(driver.getCurrentUrl(),
				FileReaderManager.getInstance().getConfigReader().getOperationInStackUrl());
		Log.info("Verifies that user is on Operation- in-stack Page");
		// Assert.assertEquals(driver.getCurrentUrl(),"https://dsportalapp.herokuapp.com/stack/operations-in-stack/");
	}

	public void ClickImplementationLink() {
		implementationLink.click();
		Log.info("User clicked on Implementation");
	}

	public void NavigateToImplementationPage() {
		Assert.assertEquals(driver.getCurrentUrl(),
				FileReaderManager.getInstance().getConfigReader().getImplimentationUrl());
		Log.info("Verifies that user is on Implemenation Page");
		// Assert.assertEquals(driver.getCurrentUrl(),"https://dsportalapp.herokuapp.com/stack/implementation/");
	}

	public void ClickApplicationsLink() {
		applicationsLink.click();
		Log.info("User clicked on get started button");
	}

	public void NavigateToApplicationsPage() {
		Assert.assertEquals(driver.getCurrentUrl(),
				FileReaderManager.getInstance().getConfigReader().getstackApplicationUrl());
		Log.info("Verifies that user is on Stack-Application Page");
		// Assert.assertEquals(driver.getCurrentUrl(),"https://dsportalapp.herokuapp.com/stack/stack-applications/");
	}

	public void TryHereButton() {
		tryHereButton.click();
		Log.info("User clicked on try here button");
	}

	public void NavigateToTryHerePage() {
		Assert.assertEquals(driver.getCurrentUrl(),
				FileReaderManager.getInstance().getConfigReader().getEditorPageUrl());
		Log.info("Verifies that user is on Editor Page");
		// Assert.assertEquals(driver.getCurrentUrl(),"https://dsportalapp.herokuapp.com/tryEditor");
	}

	public void ValidPythonCode(String textEdit) {
		driver.navigate().refresh();
		action = new Actions(driver);
		// action.sendKeys(textEditor);//.perform();
		action.sendKeys(textEditor, textEdit).build().perform();
		// System.out.println("Python code"+textEdit);
		// driver.findElement(textEditor).sendKeys(textEdit);
		// System.out.println("python code from excel"+textEdit);
		Log.info("User entered python code");
	}

	public void invalidPythonCode() {
		action = new Actions(driver);
		// textEditor.clear();
		driver.navigate().back();
		tryHereButton.click();
		Log.info("User entered invalid python code");
		// action.sendKeys(textEditor,"print I am Not Valid code").perform();
		// driver.findElement(textEditor).sendKeys("print I am Not Valid code");
	}

	public void ClickRunButton() {
		runButton.click();
		Log.info("User clicked on Run button");
	}
}

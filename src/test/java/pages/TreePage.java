package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readers.ConfigFileReader;
import managers.PageObjectManager;
//import utils.DriverFactory;
import utils.LoggerLoad;
//import managers.DriverManager;


public class TreePage {
	WebDriver driver;
	//public static WebDriver driver;

	//public static WebDriver driver =DriverFactory.getDriver;
	ConfigFileReader cr = new ConfigFileReader();
	String loginurl = ConfigFileReader.loginPage();
    String homeUrl="https://dsportalapp.herokuapp.com/home";
    String tryEditorURL=ConfigFileReader.tryEditorURL();
	String tryhereurl=ConfigFileReader.gettryhereurl();
	String treeurl=ConfigFileReader.getTreeUrl();
	@FindBy(xpath = "//input[@id='id_username']")WebElement username;
	
	@FindBy(xpath = "//input[@id='id_password']")WebElement password;
	@FindBy(xpath = "//input[@value='Login']")WebElement loginbtn;
	@FindBy(xpath="//div[@class='col'][6]//a")WebElement TreeGetStart;
	@FindBy(linkText="Overview of Trees") WebElement OverOfTree;
	@FindBy(linkText="Terminologies") WebElement Terminologies;
	@FindBy(linkText="Types of Trees") WebElement TypesOfTree;
	@FindBy(linkText="Tree Traversals") WebElement TreeTrave;
	@FindBy(linkText="Traversals-Illustration") WebElement TraveIllustrate;
	@FindBy(linkText="Binary Trees") WebElement BinaryTree;
	@FindBy(linkText="Types of Binary Trees") WebElement TypesOfBinary;
	@FindBy(linkText="Implementation in Python") WebElement ImplementPython;
	@FindBy(linkText="Binary Tree Traversals") WebElement BTTraverse;
	@FindBy(linkText="Implementation of Binary Trees") WebElement ImplementBT;
	@FindBy(linkText="Applications of Binary trees") WebElement AppsOfBT;
	@FindBy(linkText="Binary Search Trees") WebElement BST;
	@FindBy(linkText="Implementation Of BST") WebElement ImplementBST;
	@FindBy(linkText="Try here>>>") WebElement TryhereLink;
	@FindBy (xpath ="//form/div/div/div/textarea") WebElement textEditor; 
	@FindBy(xpath ="//button[text()='Run']") WebElement runBtn;
	@FindBy(id="output") WebElement runOutput;
	@FindBy(linkText="Practice Questions") WebElement PQues;
	
	
	
	public TreePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void getLoginurl() {
		driver.get(loginurl);
	}
	public void enterUsername(String userName) {

		username.sendKeys(userName);

	}
	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickLogin() {
		loginbtn.click();
	}
	public void homePage() {
		driver.get(homeUrl);
		
	}
	public void ClickTreeGS() {
		LoggerLoad.info("User Click the tree Get Started Button");
		TreeGetStart.click();
	}
	public void ClickOverview() {
		LoggerLoad.info("User Clicks on Overview of Tree link");
		OverOfTree.click();
	}
	public void ClickTerminology() {
		LoggerLoad.info("User Clicks on Terminologies link");
		Terminologies.click();
	}
	public void ClickTypesOFTree() {
		LoggerLoad.info("User Clicks on Types of tree link");
		TypesOfTree.click();
	}
	public void ClickTreeTraversal() {
		LoggerLoad.info("User Clicks on  tree traversal link");
		TreeTrave.click();
	}
	public void ClickTraveIllustrate() {
		LoggerLoad.info("User Clicks on  traversal Illustration  link");
		TraveIllustrate.click();
	}
	public void ClickBinaryTree() {
		LoggerLoad.info("User Clicks on  Binary Tree link");
		BinaryTree.click();
	}
	public void ClickTypesOfBinary() {
		LoggerLoad.info("User Clicks on types of Binary tree link");
		TypesOfBinary.click();
	}
	public void ClickImplementPython() {
		LoggerLoad.info("User Clicks on Implementation of Python link");
		ImplementPython.click();
	}
	public void ClickBTTraverse() {
		LoggerLoad.info("User Clicks on Binary tree traversal link");
		BTTraverse.click();
	}
	public void ClickImplementBT() {
		LoggerLoad.info("User Clicks on Implementation of Binary Trees link");
		ImplementBT.click();
	}
	public void ClickAppsOfBT() {
		LoggerLoad.info("User Clicks on Applications of Binary Trees link");
		AppsOfBT.click();
	}
	public void ClickBinarySearchTree() {
		LoggerLoad.info("User Clicks on  Binary Search Trees link");
		BST.click();
	}
	public void ClickImplementBST() {
		LoggerLoad.info("User Clicks on Implementation of Binary Search Trees link");
		ImplementBST.click();
	}
	public void ClickTryhereLink() {
		LoggerLoad.info("User Clicks on Try Here button");
		TryhereLink.click();
	}
	
	public void enterCode(String pythonCode) throws InterruptedException {
		LoggerLoad.info("User enter the valid print statement");
		textEditor.sendKeys(pythonCode);
	} 
	
	public void clickRunBtn() throws InterruptedException {
		LoggerLoad.info("User Clicked Run button");
		Thread.sleep(1000);
		runBtn.click();
	}
	public String getOutput() {
		LoggerLoad.info("Output after Run Statement:" +runOutput.getText());
		String Result = runOutput.getText();
		return Result ;
		
	}
	public String getErrormsg() {
		String errormsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errormsg;
	}
	public void ClickPractQuesLink() {
		LoggerLoad.info("User Clicks the Practice Questions link");
		PQues.click();
	}

}



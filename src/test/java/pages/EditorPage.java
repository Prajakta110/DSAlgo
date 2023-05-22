package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utilities.Log;

public class EditorPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='CodeMirror-lines']") WebElement codeTextArea;
	@FindBy(xpath = "//button[text()='Run']") WebElement runButton;
	@FindBy(xpath = "//pre[@id='output']") WebElement output;
	@FindBy(xpath = "//*[@value='Submit']") WebElement submitButton;
	
	public EditorPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyTryEditorPage()
	{
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getEditorPageUrl());
		Log.info("Verified that user is on Editor page");
	}
	
	public void RunCodeInTryEditor(String pythonCode)
	{
		//driver.navigate().refresh();
		Actions action = new Actions(driver);
		
		action.click(codeTextArea)
			    .keyDown(Keys.CONTROL)
			    .sendKeys("A")
			    .keyUp(Keys.CONTROL)
			    .sendKeys(Keys.DELETE)
			    .build()
			    .perform();
		
		action.sendKeys(codeTextArea, pythonCode).build().perform();
		Log.info("User entered pythin code in Editor");
		
		runButton.click();
		Log.info("User clicked on Run button on Editor");
	}
	
	public void VerifyOutput(String outputText)
	{
		Assert.assertEquals(output.getText(), outputText);
		Log.info("Verified the output of python code executed");
	}
	
	public void VerifyErrorMessage(String expectedMsg)
	{
		String actualMsg = driver.switchTo().alert().getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		Log.info("Verified the error message for invalid code. "
				+ "Expected message - " + expectedMsg + ". Actual message - " + actualMsg);
		
		driver.switchTo().alert().accept();
	}
	
	public void ExitEditorPage()
	{
		driver.navigate().back();
		Log.info("User navigated back from Editor page");
	}
	
	public void ClickOnSubmit()
	{
		submitButton.click();
		Log.info("User clicked on Submit button on Practice Questions Editor page");
	}

}
